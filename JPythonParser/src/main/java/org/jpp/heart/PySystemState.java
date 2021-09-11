// Copyright (c) Corporation for National Research Initiatives
package org.jpp.heart;

import jnr.posix.util.Platform;
import org.jpp.heart.adapter.ClassicPyObjectAdapter;
import org.jpp.heart.adapter.ExtensiblePyObjectAdapter;
import org.jpp.heart.packagecache.PackageManager;
import org.jpp.heart.packagecache.SysPackageManager;
import org.jpp.exposers.ExposedGet;
import org.jpp.exposers.ExposedType;
import org.jpp.modules.PyNamespace;
import org.jpp.modules.Setup;
import org.jpp.modules.sys.SysModule;
import org.jpp.modules._imp;
import org.jpp.modules.zipimport.PyZipImporter;
import org.jpp.util.Generic;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.security.AccessControlException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PySystemState extends PyObject implements AutoCloseable, Closeable, Traverseproc {

    public static final String PYTHON_CACHEDIR = "python.cachedir";
    public static final String PYTHON_CACHEDIR_SKIP = "python.cachedir.skip";
    public static final String PYTHON_CONSOLE_ENCODING = "python.console.encoding";
    public static final String PYTHON_IO_ENCODING = "python.io.encoding";
    public static final String PYTHON_IO_ERRORS = "python.io.errors";
    protected static final String CACHEDIR_DEFAULT_NAME = "cachedir";

    public static final String JYTHON_JAR = "jython.jar";
    public static final String JYTHON_DEV_JAR = "jython-dev.jar";

    private static final String JAR_URL_PREFIX = "jar:file:";
    private static final String JAR_SEPARATOR = "!";
    private static final String VFSZIP_PREFIX = "vfszip:";
    private static final String VFS_PREFIX = "vfs:";

    // XXX: should this be "mbcs" on Windows, like on CPython?
    private static final PyUnicode fileSystemEncoding = new PyUnicode(System.getProperty("file.encoding"));

    public static final PyUnicode version = new PyUnicode(Version.getVersion());

    public static final PyTuple subversion = new PyTuple(new PyUnicode("Jython"), Py.EmptyUnicode,
            Py.EmptyUnicode);

    public static final int hexversion = ((Version.PY_MAJOR_VERSION << 24)
            | (Version.PY_MINOR_VERSION << 16) | (Version.PY_MICRO_VERSION << 8)
            | (Version.PY_RELEASE_LEVEL << 4) | (Version.PY_RELEASE_SERIAL << 0));

    public static final PyTuple version_info = getVersionInfo();

    // XXX: we should someday make this Long.MAX_VALUE, but see test_index.py
    // for tests that would need to pass but today would not.
    public final static int maxsize = Integer.MAX_VALUE;

    public final static PyUnicode float_repr_style = Py.newUnicode("short");

    public final static Class flags = Options.class;

    public final static PyTuple _mercurial = new PyTuple(
            Py.newUnicode("Jython"),
            Py.newUnicode(Version.getHGIdentifier()),
            Py.newUnicode(Version.getHGVersion()));
    /**
     * The copyright notice for this release.
     */

    public static final PyObject copyright = Py.newUnicode(
            "Copyright (c) 2000-2015 Jython Developers.\n" + "All rights reserved.\n\n" +
            "Copyright (c) 2000 BeOpen.com.\n" + "All Rights Reserved.\n\n" +
            "Copyright (c) 2000 The Apache Software Foundation.\n" + "All rights reserved.\n\n" +
            "Copyright (c) 1995-2000 Corporation for National Research Initiatives.\n"
                + "All Rights Reserved.\n\n" +
            "Copyright (c) 1991-1995 Stichting Mathematisch Centrum, Amsterdam.\n"
                + "All Rights Reserved.");

    private static Map<String, String> builtinNames;
    public static PyTuple builtin_module_names = null;

    public static PackageManager packageManager;
    private static File cachedir;

    private static PyList defaultPath;
    private static PyList defaultArgv;
    private static PyObject defaultExecutable;

    public static Properties registry; // = init_registry();
    public static PyObject prefix;
    public static PyObject base_prefix;
    public static PyObject exec_prefix = Py.EmptyUnicode;
    public static PyObject base_exec_prefix = exec_prefix;

    public static final PyUnicode byteorder = new PyUnicode("big");
    public static final int maxint = Integer.MAX_VALUE;
    public static final int minint = Integer.MIN_VALUE;

    private static boolean initialized = false;

    /** The arguments passed to this program on the command line. */
    public PyList argv = new PyList();

    public PyObject modules;
    public PyObject sysdict;
    public Map<String, PyModule> modules_reloading;
    private ReentrantLock importLock;
    private ClassLoader syspathJavaLoader;
    public PyList path;

    public PyList warnoptions = new PyList();
    public PyObject builtins;
    private static PyObject defaultPlatform = Py.newUnicode("java");
    public PyObject platform;

    public PyNamespace implementation;

    // _frozen_importlib
    public PyObject importlib;
    public PyList meta_path;
    public PyList path_hooks;
    public PyObject path_importer_cache;

    // Only defined if interactive, see https://docs.python.org/2/library/sys.html#sys.ps1
    public PyObject ps1 = PyAttributeDeleted.INSTANCE;
    public PyObject ps2 = PyAttributeDeleted.INSTANCE;

    public PyObject executable;

    private String currentWorkingDir;

    private ClassLoader classLoader = null;

    private PyObject __displayhook__, __excepthook__;

    public PyObject last_value = Py.None;
    public PyObject last_type = Py.None;
    public PyObject last_traceback = Py.None;

    public PyObject __name__ = new PyUnicode("sys");

    public PyObject __dict__;

    private int recursionlimit = 1000;

    private codecs.CodecState codecState;

    /** true when a SystemRestart is triggered. */
    public boolean _systemRestart = false;

    /** Whether bytecode should be written to disk on import. */
    public boolean dont_write_bytecode = false;

    // Automatically close resources associated with a PySystemState when they get GCed
    public final PySystemStateCloser closer;

    public void registerCloser(Callable<Void> resourceCloser) {
        closer.registerCloser(resourceCloser);
    }

    public boolean unregisterCloser(Callable<Void> resourceCloser) {
        return closer.unregisterCloser(resourceCloser);
    }

    private static final ReferenceQueue<PySystemState> systemStateQueue =
            new ReferenceQueue<PySystemState>();
    private static final ConcurrentMap<WeakReference<PySystemState>, PySystemStateCloser> sysClosers =
            Generic.concurrentMap();

    // float_info
    public static final PyObject float_info = FloatInfo.getInfo();

    // long_info
    public static final PyObject long_info = LongInfo.getInfo();

    public PySystemState() {
        initialize();
        initImplementation();
        closer = new PySystemStateCloser(this);
        modules = new PyStringMap();
        modules_reloading = new HashMap<String, PyModule>();
        importLock = new ReentrantLock();
        syspathJavaLoader = new SyspathJavaLoader(imp.getParentClassLoader());

        argv = (PyList)defaultArgv.repeat(1);
        path = (PyList)defaultPath.repeat(1);
        path.append(Py.newUnicode(JavaImporter.JAVA_IMPORT_PATH_ENTRY));
//        path.append(Py.newUnicode(ClasspathPyImporter.PYCLASSPATH_PREFIX));
        executable = defaultExecutable;
        builtins = getDefaultBuiltins();
        platform = defaultPlatform;

        meta_path = new PyList();
        path_hooks = new PyList();
        path_hooks.append(PyZipImporter.TYPE);
//        path_hooks.append(ClasspathPyImporter.TYPE);

        path_importer_cache = new PyDictionary();
        path_importer_cache.__setitem__(Py.newUnicode(JavaImporter.JAVA_IMPORT_PATH_ENTRY), new JavaImporter());

        currentWorkingDir = new File("").getAbsolutePath();

        dont_write_bytecode = Options.dont_write_bytecode;
        // Set up the initial standard ins and outs
//        initstdio();
//        initEncoding();

        __displayhook__ = new PySystemStateFunctions("displayhook", 10, 1, 1);
        __excepthook__ = new PySystemStateFunctions("excepthook", 30, 3, 3);

        if (builtins == null) {
            builtins = getDefaultBuiltins();
        }
        modules.__setitem__("__builtin__", new PyModule("__builtin__", getDefaultBuiltins()));
        __dict__ = new PyStringMap();
        __dict__.invoke("update", getType().fastGetDict());
        __dict__.__setitem__("displayhook", __displayhook__);
        __dict__.__setitem__("excepthook", __excepthook__);

    }

    void reload() throws PyIgnoreMethodTag {
        __dict__.invoke("update", getType().fastGetDict());
    }

    private static void checkReadOnly(String name) {
        if (name == "__dict__" || name == "__class__" || name == "registry"
                || name == "exec_prefix" || name == "packageManager") {
            throw Py.TypeError("readonly attribute");
        }
    }

    private static void checkMustExist(String name) {
        if (name == "__dict__" || name == "__class__" || name == "registry"
                || name == "exec_prefix" || name == "platform" || name == "packageManager"
                || name == "builtins" || name == "warnoptions") {
            throw Py.TypeError("readonly attribute");
        }
    }

    /**
     * Initialise the encoding of <code>sys.stdin</code>, <code>sys.stdout</code>, and
     * <code>sys.stderr</code>, and their error handling policy, from registry variables.
     * Under the console app org.jpp.util.jython, values reflect PYTHONIOENCODING if not overridden.
     * Note that the encoding must name a Python codec, as in <code>codecs.encode()</code>.
     */
    private void initEncoding() {
        // Two registry variables, counterparts to PYTHONIOENCODING = [encoding][:errors]
        String encoding = registry.getProperty(PYTHON_IO_ENCODING);
        String errors = registry.getProperty(PYTHON_IO_ERRORS);

        if (encoding==null) {
            // We still don't have an explicit selection for this: match the console.
            encoding = Py.getConsole().getEncoding();
        }

        ((PyFile)getStdin()).setEncoding(encoding, errors);
        ((PyFile)getStdout()).setEncoding(encoding, errors);
        ((PyFile)getStderr()).setEncoding(encoding, "backslashreplace");
    }

    private void initImplementation() {
        Map<String, PyObject> dict = new HashMap<>();
        dict.put("cache_tag", new PyUnicode(Version.PY_CACHE_TAG));
        dict.put("hexversion", new PyLong(hexversion));
        dict.put("name", new PyUnicode("Jython"));
        dict.put("version", version_info);
        dict.put("release_level", new PyUnicode(Version.PY_RELEASE_LEVEL));
        dict.put("serial", new PyLong(Version.PY_RELEASE_SERIAL));
        implementation = new PyNamespace(dict);
    }

    @Deprecated
    public void shadow() {
        // Now a no-op
    }

    private static class DefaultBuiltinsHolder {

        static final PyObject builtins = fillin();

        static PyObject fillin() {
            PyObject temp = new PyStringMap();
            __builtin__.fillWithBuiltins(temp);
            __builtin__.fillWithBuiltinExceptions(temp);
            return temp;
        }
    }

    public static PyObject getDefaultBuiltins() {
        return DefaultBuiltinsHolder.builtins;
    }

    public PyObject getBuiltins() {
        return builtins;
    }

    public PyObject getStdout() {
        return sysdict.__getitem__("stdout");
    }

    public PyObject getStderr() {
        return sysdict.__getitem__("stderr");
    }

    public PyObject getStdin() {
        return sysdict.__getitem__("stdin");
    }

    public void setStdout(PyObject stdout) {
        sysdict.__setitem__("stdout", stdout);
    }

    public void setStderr(PyObject stderr) {
        sysdict.__setitem__("stderr", stderr);
    }

    public void setBuiltins(PyObject value) {
        builtins = value;
        modules.__setitem__("__builtin__", new PyModule("__builtin__", value));
    }

    public PyObject getWarnoptions() {
        return warnoptions;
    }

    public void setWarnoptions(PyObject value) {
        warnoptions = new PyList(value);
    }

    public PyObject getPlatform() {
        return platform;
    }

    public void setPlatform(PyObject value) {
        platform = value;
    }

    public synchronized codecs.CodecState getCodecState() {
        if (codecState == null) {
            codecState = new codecs.CodecState();
//            try {
//                imp.load("encodings");
//            } catch (PyException exc) {
//                if (exc.type != Py.ImportError) {
//                    throw exc;
//                }
//            }
        }
        return codecState;
    }

    public ReentrantLock getImportLock() {
        return importLock;
    }

    public ClassLoader getSyspathJavaLoader() {
        return syspathJavaLoader;
    }

    // xxx fix this accessors
    @Override
    public PyObject __findattr_ex__(String name) {
        if (name == "exc_value") {
            PyException exc = Py.getThreadState().exceptions.peek();
            if (exc == null) {
                return null;
            }
            return exc.value;
        } else if (name == "exc_type") {
            PyException exc = Py.getThreadState().exceptions.peek();
            if (exc == null) {
                return null;
            }
            return exc.type;
        } else if (name == "exc_traceback") {
            PyException exc = Py.getThreadState().exceptions.peek();
            if (exc == null) {
                return null;
            }
            return exc.traceback;
        } else {
            PyObject ret = super.__findattr_ex__(name);
            if (ret != null) {
                if (ret instanceof PyMethod) {
                    if (__dict__.__finditem__(name) instanceof PyReflectedFunction) {
                        return ret; // xxx depends on nonstandard __dict__
                    }
                } else if (ret == PyAttributeDeleted.INSTANCE) {
                    return null;
                } else {
                    return ret;
                }
            }

            return __dict__.__finditem__(name);
        }
    }

    @Override
    public void __setattr__(String name, PyObject value) {
        checkReadOnly(name);
        if (name == "builtins") {
            setBuiltins(value);
        } else {
            PyObject ret = getType().lookup(name); // xxx fix fix fix
            if (ret != null && ret._doset(this, value)) {
                return;
            }
            __dict__.__setitem__(name, value);
        }
    }

    @Override
    public void __delattr__(String name) {
        checkMustExist(name);
        PyObject ret = getType().lookup(name); // xxx fix fix fix
        if (ret != null) {
            ret._doset(this, PyAttributeDeleted.INSTANCE);
        }
        try {
            __dict__.__delitem__(name);
        } catch (PyException pye) { // KeyError
            if (ret == null) {
                throw Py.AttributeError(name);
            }
        }
    }

    // xxx
    @Override
    public void __rawdir__(PyDictionary accum) {
        accum.update(__dict__);
    }

    @Override
    public String toString() {
        return "<module '" + __name__ + "' (built-in)>";
    }

    public int getrecursionlimit() {
        return recursionlimit;
    }

    public void setrecursionlimit(int recursionlimit) {
        if (recursionlimit <= 0) {
            throw Py.ValueError("Recursion limit must be positive");
        }
        this.recursionlimit = recursionlimit;
    }

    public PyObject gettrace() {
        ThreadState ts = Py.getThreadState();
        if (ts.tracefunc == null) {
            return Py.None;
        } else {
            return ((PythonTraceFunction)ts.tracefunc).tracefunc;
        }
    }

    public void settrace(PyObject tracefunc) {
        ThreadState ts = Py.getThreadState();
        if (tracefunc == Py.None) {
            ts.tracefunc = null;
        } else {
            ts.tracefunc = new PythonTraceFunction(tracefunc);
        }
    }

    public PyObject getprofile() {
        ThreadState ts = Py.getThreadState();
        if (ts.profilefunc == null) {
            return Py.None;
        } else {
            return ((PythonTraceFunction)ts.profilefunc).tracefunc;
        }
    }

    public void setprofile(PyObject profilefunc) {
        ThreadState ts = Py.getThreadState();
        if (profilefunc == Py.None) {
            ts.profilefunc = null;
        } else {
            ts.profilefunc = new PythonTraceFunction(profilefunc);
        }
    }

    public PyUnicode getdefaultencoding() {
        return new PyUnicode(codecs.getDefaultEncoding());
    }

    public PyObject getfilesystemencoding() {
        return fileSystemEncoding;
    }

    /**
     * Change the current working directory to the specified path.
     *
     * path is assumed to be absolute and canonical (via os.path.realpath).
     *
     * @param path a path String
     */
    public void setCurrentWorkingDir(String path) {
        currentWorkingDir = path;
    }

    /**
     * Return a string representing the current working directory.
     *
     * @return a path String
     */
    public String getCurrentWorkingDir() {
        return currentWorkingDir;
    }

    /**
     * Resolve a path. Returns the full path taking the current working directory into account.
     *
     * @param path a path String
     * @return a resolved path String
     */
    public String getPath(String path) {
        return getPath(this, path);
    }

    /**
     * Resolve a path. Returns the full path taking the current working directory into account.
     *
     * Like getPath but called statically. The current PySystemState is only consulted for the
     * current working directory when it's necessary (when the path is relative).
     *
     * @param path a path String
     * @return a resolved path String
     */
    public static String getPathLazy(String path) {
        // XXX: This method likely an unnecessary optimization
        return getPath(null, path);
    }

    private static String getPath(PySystemState sys, String path) {
        if (path != null) {
            path = getFile(sys, path).getAbsolutePath();
        }
        return path;
    }

    /**
     * Resolve a path, returning a {@link File}, taking the current working directory into account.
     *
     * @param path a path <code>String</code>
     * @return a resolved <code>File</code>
     */
    public File getFile(String path) {
        return getFile(this, path);
    }

    /**
     * Resolve a path, returning a {@link File}, taking the current working directory of the
     * specified <code>PySystemState</code> into account. Use of a <code>static</code> here is a
     * trick to avoid getting the current state if the path is absolute. (Noted that this may be
     * needless optimisation.)
     *
     * @param sys a <code>PySystemState</code> or null meaning the current one
     * @param path a path <code>String</code>
     * @return a resolved <code>File</code>
     */
    private static File getFile(PySystemState sys, String path) {
        File file = new File(path);
        if (!file.isAbsolute()) {
            // path meaning depends on the current working directory
            if (sys == null) {
                sys = Py.getSystemState();
            }
            String cwd = sys.getCurrentWorkingDir();
            if (Platform.IS_WINDOWS) {
                // Form absolute reference (with mysterious Windows semantics)
                file = getWindowsFile(cwd, path);
            } else {
                // Form absolute reference (with single slash)
                file = new File(cwd, path);
            }
        }
        return file;
    }

    /**
     * Resolve a relative path against the supplied current working directory or Windows environment
     * working directory for any drive specified in the path. and return a file object. Essentially
     * equivalent to os.path.join, but the work is done by {@link File}. The intention is that
     * calling {@link File#getAbsolutePath()} should return the corresponding absolute path.
     * <p>
     * Note: in the context where we use this method, <code>path</code> is already known not to be
     * absolute, and <code>cwd</code> is assumed to be absolute.
     *
     * @param cwd current working directory (of some {@link PySystemState})
     * @param path to resolve
     * @return specifier of the intended file
     */
    private static File getWindowsFile(String cwd, String path) {
        // Assumptions: cwd is absolute and path is not absolute

        // Start by getting the slashes the right (wrong) way round.
        if (path.indexOf('/') >= 0) {
            path = path.replace('/', '\\');
        }

        // Does path start with a drive letter?
        char d = driveLetter(path);
        if (d != 0) {
            if (d == driveLetter(cwd)) {
                /*
                 * path specifies the same drive letter as in the cwd of this PySystemState. Let
                 * File interpret the rest of the path relative to cwd as parent.
                 */
                return new File(cwd, path.substring(2));
            } else {
                // Let File resolve the specified drive against the process environment.
                return new File(path);
            }

        } else if (path.startsWith("\\")) {
            // path replaces the file part of the cwd. (Method assumes path is not UNC.)
            if (driveLetter(cwd) != 0) {
                // cwd has a drive letter
                return new File(cwd.substring(0, 2), path);
            } else {
                // cwd has no drive letter, so should be a UNC path \\host\share\directory\etc
                return new File(uncShare(cwd), path);
            }

        } else {
            // path is relative to the cwd of this PySystemState.
            return new File(cwd, path);
        }
    }

    /**
     * Return the Windows drive letter from the start of the path, upper case, or 0 if
     * the path does not start X: where X is a letter.
     *
     * @param path to examine
     * @return drive letter or char 0 if no drive letter
     */
    private static char driveLetter(String path) {
        if (path.length() >= 2 && path.charAt(1) == ':') {
            // Looks like both strings start with a drive letter
            char pathDrive = path.charAt(0);
            if (Character.isLetter(pathDrive)) {
                return Character.toUpperCase(pathDrive);
            }
        }
        return (char)0;
    }

    /**
     * Return the Windows UNC share name from the start of the path, or <code>null</code> if the
     * path is not of Windows UNC type. The path has to be formed with Windows-backslashes:
     * slashes '/' are not accepted as a substitute here.
     *
     * @param path to examine
     * @return share name or null
     */
    private static String uncShare(String path) {
        int n = path.length();
        // Has to accommodate at least \\A (3 chars)
        if (n >= 5 && path.startsWith("\\\\")) {
            // Look for the separator backslash A\B
            int p = path.indexOf('\\', 2);
            // Has to be at least index 3 (path begins \\A) and 2 more characters left \B
            if (p >= 3 && n > p + 2) {
                // Look for directory backslash that ends the share name
                int dir = path.indexOf('\\', p + 1);
                if (dir < 0) {
                    // path has the form \\A\B (is just the share name)
                    return path;
                } else if (dir > p + 1) {
                    // path has the form \\A\B\C
                    return path.substring(0, dir);
                }
            }
        }
        return null;
    }

    public void callExitFunc() throws PyIgnoreMethodTag {
        PyObject exitfunc = __findattr__("exitfunc");
        if (exitfunc != null) {
            try {
                exitfunc.__call__();
            } catch (PyException exc) {
                if (!exc.match(Py.SystemExit)) {
                    Py.println(getStderr(), Py.newUnicode("Error in sys.exitfunc:"));
                }
                Py.printException(exc);
            }
        }
        Py.flushLine();
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    private static String findRoot(Properties preProperties, Properties postProperties,
            String jarFileName) {
        String root = null;
        try {
            if (postProperties != null) {
                root = postProperties.getProperty("python.home");
            }
            if (root == null) {
                root = preProperties.getProperty("python.home");
            }
            if (root == null) {
                root = preProperties.getProperty("install.root");
            }
            determinePlatform(preProperties);
        } catch (Exception exc) {
            return null;
        }
        // If install.root is undefined find JYTHON_JAR in class.path
        if (root == null || root.equals("")) {
            String classpath = preProperties.getProperty("java.class.path");
            if (classpath != null) {
                String lowerCaseClasspath = classpath.toLowerCase();
                int jarIndex = lowerCaseClasspath.indexOf(JYTHON_JAR);
                if (jarIndex < 0) {
                    jarIndex = lowerCaseClasspath.indexOf(JYTHON_DEV_JAR);
                }
                if (jarIndex >= 0) {
                    int start = classpath.lastIndexOf(File.pathSeparator, jarIndex) + 1;
                    root = classpath.substring(start, jarIndex);
                } else if (jarFileName != null) {
                    // in case JYTHON_JAR is referenced from a MANIFEST inside another jar on the
                    // classpath
                    root = new File(jarFileName).getParent();
                }
            }
        }
        if (root == null) {
            return null;
        }
        File rootFile = new File(root);
        try {
            return rootFile.getCanonicalPath();
        } catch (IOException ioe) {
            return rootFile.getAbsolutePath();
        }
    }

    private static void determinePlatform(Properties props) {
        String version = props.getProperty("java.version");
        if (version == null) {
            version = "???";
        }
        String lversion = version.toLowerCase();
        if (lversion.startsWith("java")) {
            version = version.substring(4, version.length());
        }
        if (lversion.startsWith("jdk") || lversion.startsWith("jre")) {
            version = version.substring(3, version.length());
        }
        if (version.equals("12")) {
            version = "1.2";
        }
        defaultPlatform = new PyUnicode("java" + version);
    }

    private static void initRegistry(Properties preProperties, Properties postProperties,
            boolean standalone, String jarFileName) {
        if (registry != null) {
            Py.writeError("systemState", "trying to reinitialize registry");
            return;
        }

        registry = preProperties;
        String prefix = findRoot(preProperties, postProperties, jarFileName);
        String exec_prefix = prefix;

        // Load the default registry
        if (prefix != null) {
            if (prefix.length() == 0) {
                prefix = exec_prefix = ".";
            }
            try {
                // user registry has precedence over installed registry
                File homeFile = new File(registry.getProperty("user.home"), ".jython");
                addRegistryFile(homeFile);
                addRegistryFile(new File(prefix, "registry"));
            } catch (Exception exc) {
                // Continue
            }
        }
        if (prefix != null) {
            PySystemState.prefix = Py.newUnicode(prefix);
            PySystemState.base_prefix = PySystemState.prefix;
        }
        if (exec_prefix != null) {
            PySystemState.exec_prefix = Py.newUnicode(exec_prefix);
            PySystemState.base_exec_prefix = Py.newUnicode(exec_prefix);
        }
        try {
            String pythonpath = System.getenv("PYTHONPATH");
            if (pythonpath != null) {
                registry.setProperty("python.path", pythonpath);
            }
        } catch (SecurityException e) {
            // Continue
        }

        // Now the post properties (possibly set by custom JythonInitializer).
        registry.putAll(postProperties);
        if (standalone) {
            // set default standalone property (if not yet set)
            if (!registry.containsKey(PYTHON_CACHEDIR_SKIP)) {
                registry.put(PYTHON_CACHEDIR_SKIP, "true");
            }
        }

        /*
         *  The console encoding is the one used by line-editing consoles to decode on the OS side and
         *  encode on the Python side. It must be a Java codec name, so any relationship to
         *  python.io.encoding is dubious.
         */
        if (!registry.containsKey(PYTHON_CONSOLE_ENCODING)) {
            String encoding = getPlatformEncoding();
            if (encoding != null) {
                registry.put(PYTHON_CONSOLE_ENCODING, encoding);
            }
        }

        // Set up options from registry
        Options.setFromRegistry();
    }

    /**
     * Return the encoding of the underlying platform, if we can work it out by any means at all.
     *
     * @return the encoding of the underlying platform
     */
    private static String getPlatformEncoding() {
        // first try to grab the Console encoding
        String encoding = getConsoleEncoding();
        if (encoding == null) {
            try {
                // Not quite the console encoding (differs on Windows)
                encoding = System.getProperty("file.encoding");
            } catch (SecurityException se) {
                // ignore, can't do anything about it
            }
        }
        return encoding;
    }

    /**
     * @return the console encoding; can be <code>null</code>
     */
    private static String getConsoleEncoding() {
        String encoding = null;
        try {
            Method encodingMethod = java.io.Console.class.getDeclaredMethod("encoding");
            encodingMethod.setAccessible(true); // private static method
            encoding = (String)encodingMethod.invoke(Console.class);
        } catch (Exception e) {
            // ignore any exception
        }
        return encoding;
    }

    /**
     * Merge the contents of a property file into the registry without overriding any values already
     * set there.
     *
     * @param file
     */
    private static void addRegistryFile(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                // pre (e.g. system) properties should override the registry,
                // therefore only add missing properties from this registry file
                Properties fileProperties = new Properties();
                try {
                    FileInputStream fp = new FileInputStream(file);
                    try {
                        fileProperties.load(fp);
                        for (Entry kv : fileProperties.entrySet()) {
                            Object key = kv.getKey();
                            if (!registry.containsKey(key)) {
                                registry.put(key, kv.getValue());
                            }
                        }
                    } finally {
                        fp.close();
                    }
                } catch (IOException e) {
                    System.err.println("couldn't open registry file: " + file.toString());
                }
            } else {
                System.err.println("warning: " + file.toString() + " is a directory, not a file");
            }
        }
    }

    public static Properties getBaseProperties() {
        try {
            return System.getProperties();
        } catch (AccessControlException ace) {
            return new Properties();
        }
    }

    public static synchronized void initialize() {
        initialize(null, null);
    }

    public static synchronized void initialize(Properties preProperties, Properties postProperties) {
        initialize(preProperties, postProperties, new String[] {""});
    }

    public static synchronized void initialize(Properties preProperties, Properties postProperties,
            String[] argv) {
        initialize(preProperties, postProperties, argv, null);
    }

    public static synchronized void initialize(Properties preProperties, Properties postProperties,
            String[] argv, ClassLoader classLoader) {
        initialize(preProperties, postProperties, argv, classLoader, new ClassicPyObjectAdapter());
    }

    public static synchronized void initialize(Properties preProperties, Properties postProperties,
            String[] argv, ClassLoader classLoader, ExtensiblePyObjectAdapter adapter) {
        if (initialized) {
            return;
        }
        if (preProperties == null) {
            preProperties = getBaseProperties();
        }
        if (postProperties == null) {
            postProperties = new Properties();
        }
        try {
            ClassLoader context = Thread.currentThread().getContextClassLoader();
            if (context != null) {
                if (initialize(preProperties, postProperties, argv, classLoader, adapter, context)) {
                    return;
                }
            } else {
                Py.writeDebug("initializer", "Context class loader null, skipping");
            }
            ClassLoader sysStateLoader = PySystemState.class.getClassLoader();
            if (sysStateLoader != null) {
                if (initialize(preProperties, postProperties, argv, classLoader, adapter,
                        sysStateLoader)) {
                    return;
                }
            } else {
                Py.writeDebug("initializer", "PySystemState.class class loader null, skipping");
            }
        } catch (UnsupportedCharsetException e) {
            Py.writeWarning("initializer",
                    "Unable to load the UTF-8 charset to read an initializer definition");
            e.printStackTrace(System.err);
        } catch (SecurityException e) {
            // Must be running in a security environment that doesn't allow access to the class
            // loader
            e.printStackTrace(System.err);
        } catch (Exception e) {
            Py.writeWarning("initializer",
                    "Unexpected exception thrown while trying to use initializer service");
            e.printStackTrace(System.err);
        }
        doInitialize(preProperties, postProperties, argv, classLoader, adapter);
    }

    private static final String INITIALIZER_SERVICE =
            "META-INF/services/org.jpp.heart.JythonInitializer";

    /**
     * Attempts to read a SystemStateInitializer service from the given class loader, instantiate
     * it, and initialize with it.
     *
     * @throws UnsupportedCharsetException if unable to load UTF-8 to read a service definition
     * @return true if a service is found and successfully initializes.
     */
    private static boolean initialize(Properties pre, Properties post, String[] argv,
            ClassLoader sysClassLoader, ExtensiblePyObjectAdapter adapter,
            ClassLoader initializerClassLoader) {
        InputStream in = initializerClassLoader.getResourceAsStream(INITIALIZER_SERVICE);
        if (in == null) {
            Py.writeDebug("initializer", "'" + INITIALIZER_SERVICE + "' not found on "
                    + initializerClassLoader);
            return false;
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        String className;
        try {
            className = r.readLine();
        } catch (IOException e) {
            Py.writeWarning("initializer", "Failed reading '" + INITIALIZER_SERVICE + "' from "
                    + initializerClassLoader);
            e.printStackTrace(System.err);
            return false;
        }
        Class<?> initializer;
        try {
            initializer = initializerClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            Py.writeWarning("initializer", "Specified initializer class '" + className
                    + "' not found, continuing");
            return false;
        }
        try {
            ((JythonInitializer)initializer.newInstance()).initialize(pre, post, argv,
                    sysClassLoader, adapter);
        } catch (Exception e) {
            Py.writeWarning("initializer", "Failed initializing with class '" + className
                    + "', continuing");
            e.printStackTrace(System.err);
            return false;
        }
        if (!initialized) {
            Py.writeWarning("initializer", "Initializer '" + className
                    + "' failed to call doInitialize, using default initialization");
        }
        return initialized;
    }

    public static synchronized PySystemState doInitialize(Properties preProperties,
            Properties postProperties, String[] argv, ClassLoader classLoader,
            ExtensiblePyObjectAdapter adapter) {
        if (initialized) {
            return Py.defaultSystemState;
        }
        initialized = true;
        Py.setAdapter(adapter);
        boolean standalone = false;
        String jarFileName = getJarFileName();
        if (jarFileName != null) {
            standalone = isStandalone(jarFileName);
        }

        // initialize the Jython registry
        initRegistry(preProperties, postProperties, standalone, jarFileName);

        // other initializations
        initBuiltins(registry);
//        initStaticFields();

        // Initialize the path (and add system defaults)
        defaultPath = initPath(registry, standalone, jarFileName);
        defaultArgv = initArgv(argv);
        defaultExecutable = initExecutable(registry);

        // Set up the known Java packages
        initPackages(registry);

        // Condition the console
        initConsole(registry);

        // Finish up standard Python initialization...
        Py.defaultSystemState = new PySystemState();
        Py.setSystemState(Py.defaultSystemState);
        if (classLoader != null) {
            Py.defaultSystemState.setClassLoader(classLoader);
        }
        Py.initClassExceptions(getDefaultBuiltins());
        PyModuleDef spec = new PyModuleDef("sys");
        PyObject sysmod = _imp.create_builtin(spec);
        _imp.exec_builtin(sysmod);
        Py.defaultSystemState.modules.__setitem__("sys", sysmod);
        Py.defaultSystemState.sysdict = ((PyModule) sysmod).__dict__;
        Py.defaultSystemState.sysdict.__setitem__("org/jpp/modules", Py.defaultSystemState.modules);
        Py.setSystemState(Py.defaultSystemState);

        // init sys
        SysModule.setObject("builtin_module_names", PySystemState.builtin_module_names);
        SysModule.setObject("byteorder", Py.defaultSystemState.byteorder);
        SysModule.setObject("copyright", Py.defaultSystemState.copyright);
        SysModule.setObject("dont_write_bytecode", Py.newBoolean(Py.defaultSystemState.dont_write_bytecode));
        SysModule.setObject("executable", Py.defaultSystemState.executable);
        SysModule.setObject("exec_prefix", Py.defaultSystemState.exec_prefix);
        SysModule.setObject("exec_prefix", Py.defaultSystemState.exec_prefix);
        SysModule.setObject("flags", Py.java2py(Py.defaultSystemState.flags));
        SysModule.setObject("implementation", Py.defaultSystemState.implementation);
        SysModule.setObject("maxsize", new PyLong(Py.defaultSystemState.maxsize));
        SysModule.setObject("meta_path", Py.defaultSystemState.meta_path);
        SysModule.setObject("path", Py.defaultSystemState.path);
        SysModule.setObject("path_hooks", Py.defaultSystemState.path_hooks);
        SysModule.setObject("path_importer_cache", Py.defaultSystemState.path_importer_cache);
        SysModule.setObject("platform", Py.defaultSystemState.platform);
        SysModule.setObject("prefix", Py.defaultSystemState.prefix);
        SysModule.setObject("version", Py.defaultSystemState.version);
        SysModule.setObject("version_info", Py.defaultSystemState.version_info);
        SysModule.setObject("warnoptions", Py.defaultSystemState.warnoptions);
        SysModule.setObject("base_prefix", Py.defaultSystemState.base_prefix);
        SysModule.setObject("base_exec_prefix", Py.defaultSystemState.base_exec_prefix);
        SysModule.setObject("exec_prefix", Py.defaultSystemState.exec_prefix);
        SysModule.setObject("prefix", Py.defaultSystemState.prefix);

        SysModule.setObject("ps1", Py.defaultSystemState.ps1);
        SysModule.setObject("ps2", Py.defaultSystemState.ps2);

        SysModule.setObject("argv", Py.defaultSystemState.argv);
        SysModule.setObject("displayhook", Py.defaultSystemState.__displayhook__);
        SysModule.setObject("__displayhook__", Py.defaultSystemState.__displayhook__);
        SysModule.setObject("excepthook", Py.defaultSystemState.__excepthook__);
        SysModule.setObject("__excepthook__", Py.defaultSystemState.__excepthook__);
        // end init sys

        // Make sure that Exception classes have been loaded
        new PySyntaxError("", 1, 1, "", "");

        // Cause sys to export the console handler that was installed
        SysModule.setObject("_jy_console", Py.java2py(Py.getConsole()));

        try {
            InputStream _frozen_importlib_input =  new FileInputStream(new File("src/resources/frozen_importlib/_frozen_importlib.class"));
            InputStream _frozen_importlib_external_input =  new FileInputStream(new File("src/resources/frozen_importlib/_frozen_importlib_external.class"));
            PyObject _frozen_importlib = imp.loadFromCompiled("_frozen_importlib", _frozen_importlib_input, "_bootstrap.py", "_frozen_importlib.class");
            imp.loadFromCompiled("_frozen_importlib_external", _frozen_importlib_external_input, "_bootstrap_external.py", "_frozen_importlib_external.class");
            Py.defaultSystemState.importlib = _frozen_importlib;
            _frozen_importlib.invoke("_install", sysmod, imp.loadBuiltin("_imp"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Py.defaultSystemState.initstdio();
        Py.defaultSystemState.initEncoding();
        return Py.defaultSystemState;
    }

    private static PyTuple getVersionInfo() {
        String s;
        if (Version.PY_RELEASE_LEVEL == 0x0A) {
            s = "alpha";
        } else if (Version.PY_RELEASE_LEVEL == 0x0B) {
            s = "beta";
        } else if (Version.PY_RELEASE_LEVEL == 0x0C) {
            s = "candidate";
        } else if (Version.PY_RELEASE_LEVEL == 0x0F) {
            s = "final";
        } else if (Version.PY_RELEASE_LEVEL == 0xAA) {
            s = "snapshot";
        } else {
            throw new RuntimeException("Illegal value for PY_RELEASE_LEVEL: "
                    + Version.PY_RELEASE_LEVEL);
        }
        return new PyTuple(
                Py.newInteger(Version.PY_MAJOR_VERSION),
                Py.newInteger(Version.PY_MINOR_VERSION),
                Py.newInteger(Version.PY_MICRO_VERSION),
                Py.newUnicode(s),
                Py.newInteger(Version.PY_RELEASE_SERIAL));
    }

    public static boolean isPackageCacheEnabled() {
        return cachedir != null;
    }

    private static void initCacheDirectory(Properties props) {
        String skip = props.getProperty(PYTHON_CACHEDIR_SKIP, "false");
        if (skip.equalsIgnoreCase("true")) {
            cachedir = null;
            return;
        }
        cachedir = new File(props.getProperty(PYTHON_CACHEDIR, CACHEDIR_DEFAULT_NAME));
        if (!cachedir.isAbsolute()) {
            cachedir = new File(prefix == null ? null : prefix.toString(), cachedir.getPath());
        }
    }

    private static void initPackages(Properties props) {
        initCacheDirectory(props);
        File pkgdir;
        if (cachedir != null) {
            pkgdir = new File(cachedir, "packages");
        } else {
            pkgdir = null;
        }
        packageManager = new SysPackageManager(pkgdir, props);
    }

    private static PyList initArgv(String[] args) {
        PyList argv = new PyList();
        if (args != null) {
            for (String arg : args) {
                argv.append(Py.newUnicode(arg));
            }
        }
        return argv;
    }

    /**
     * Determine the default sys.executable value from the registry. Returns Py.None is no
     * executable can be found.
     *
     * @param props a Properties registry
     * @return a PyObject path string or Py.None
     */
    private static PyObject initExecutable(Properties props) {
        String executable = props.getProperty("python.executable");
        if (executable == null) {
            return Py.None;
        }

        File executableFile = new File(executable);
        try {
            executableFile = executableFile.getCanonicalFile();
        } catch (IOException ioe) {
            executableFile = executableFile.getAbsoluteFile();
        }
        if (!executableFile.isFile()) {
            return Py.None;
        }
        return new PyUnicode(executableFile.getPath());
    }

    /**
     * Wrap standard input with a customised console handler specified in the property
     * <code>python.console</code> in the supplied property set, which in practice is the
     * fully-initialised Jython {@link #registry}. The value of <code>python.console</code> is the
     * name of a class that implements {@link org.jpp.heart.Console}. An instance is constructed
     * with the value of <code>python.console.encoding</code>, and the console
     * <code>System.in</code> returns characters in that encoding. After the call, the console
     * object may be accessed via {@link Py#getConsole()}.
     *
     * @param props containing (or not) <code>python.console</code>
     */
    private static void initConsole(Properties props) {
        // At this stage python.console.encoding is always defined (but null=default)
        String encoding = props.getProperty(PYTHON_CONSOLE_ENCODING);
        // The console type is chosen by this registry entry:
        String consoleName = props.getProperty("python.console", "").trim();
        // And must be of type ...
        final Class<Console> consoleType = Console.class;

        if (consoleName.length() > 0 && Py.isInteractive()) {
            try {
                // Load the class specified as the console
                Class<?> consoleClass = Class.forName(consoleName);

                // Ensure it can be cast to the interface type of all consoles
                if (!consoleType.isAssignableFrom(consoleClass)) {
                    throw new ClassCastException();
                }

                // Construct an instance
                Constructor<?> consoleConstructor = consoleClass.getConstructor(String.class);
                Object consoleObject = consoleConstructor.newInstance(encoding);
                Console console = consoleType.cast(consoleObject);

                // Replace System.in with stream this console manufactures
                Py.installConsole(console);
                return;

            } catch (NoClassDefFoundError e) {
                writeConsoleWarning(consoleName, "not found");
            } catch (ClassCastException e) {
                writeConsoleWarning(consoleName, "does not implement " + consoleType);
            } catch (NoSuchMethodException e) {
                writeConsoleWarning(consoleName, "has no constructor from String");
            } catch (InvocationTargetException e) {
                writeConsoleWarning(consoleName, e.getCause().toString());
            } catch (Exception e) {
                writeConsoleWarning(consoleName, e.toString());
            }
        }

        // No special console required, or requested installation failed somehow
        try {
            // Default is a plain console
            Py.installConsole(new PlainConsole(encoding));
            return;
        } catch (Exception e) {
            /*
             * May end up here if prior console won't uninstall: but then at least we have a
             * console. Or it may be an unsupported encoding, in which case Py.getConsole() will try
             * "ascii"
             */
            writeConsoleWarning(consoleName, e.toString());
        }
    }

    /**
     * Convenience method wrapping {@link Py#writeWarning(String, String)} to issue a warning
     * message something like:
     * "console: Failed to load 'org.python.org.jpp.util.ReadlineConsole': <b>msg</b>.". It's only a warning
     * because the interpreter will fall back to a plain console, but it is useful to know exactly
     * why it didn't work.
     *
     * @param consoleName console class name we're trying to initialise
     * @param msg specific cause of the failure
     */
    private static void writeConsoleWarning(String consoleName, String msg) {
        Py.writeWarning("console", "Failed to install '" + consoleName + "': " + msg + ".");
    }

    private static void addBuiltin(String name) {
        String classname;
        String modname;

        int colon = name.indexOf(':');
        if (colon != -1) {
            // name:fqclassname
            modname = name.substring(0, colon).trim();
            classname = name.substring(colon + 1, name.length()).trim();
            if (classname.equals("null")) {
                // name:null, i.e. remove it
                classname = null;
            }
        } else {
            modname = name.trim();
            classname = "org.python.org.jpp.modules." + modname;
        }
        if (classname != null) {
            builtinNames.put(modname, classname);
        } else {
            builtinNames.remove(modname);
        }
    }

    private static void initBuiltins(Properties props) {
        builtinNames = Generic.map();

        // add the oddball builtins that are specially handled
        builtinNames.put("__builtin__", "");
        builtinNames.put("sys", "");

        // add builtins specified in the Setup.java file
        for (String builtinModule : Setup.builtinModules) {
            addBuiltin(builtinModule);
        }
        for (String builtinModule : Setup.newbuiltinModules) {
            addBuiltin(builtinModule);
        }


        // add builtins specified in the registry file
        String builtinprop = props.getProperty("python.org.jpp.modules.builtin", "");
        StringTokenizer tok = new StringTokenizer(builtinprop, ",");
        while (tok.hasMoreTokens()) {
            addBuiltin(tok.nextToken());
        }

        int n = builtinNames.size();
        PyObject[] built_mod = new PyObject[n+2];
        int i = 0;
        for (String key : builtinNames.keySet()) {
            built_mod[i++] = Py.newUnicode(key);
        }
        built_mod[i++] = new PyUnicode("builtins");
        built_mod[i++] = new PyUnicode("sys");
        builtin_module_names = new PyTuple(built_mod);
    }

    public static String getBuiltin(String name) {
        return builtinNames.get(name);
    }

    private static PyList initPath(Properties props, boolean standalone, String jarFileName) {
        PyList path = new PyList();
        addPaths(path, props.getProperty("python.path", ""));
        if (prefix != null) {
            String libpath = new File(prefix.toString(), "Lib").toString();
            path.append(new PyUnicode(libpath));
        }
        if (standalone) {
            // standalone jython: add the /Lib directory inside JYTHON_JAR to the path
            addPaths(path, jarFileName + "/Lib");
        }

        return path;
    }

    /**
     * Check if we are in standalone mode.
     *
     * @param jarFileName The name of the jar file
     *
     * @return <code>true</code> if we have a standalone .jar file, <code>false</code> otherwise.
     */
    private static boolean isStandalone(String jarFileName) {
        boolean standalone = false;
        if (jarFileName != null) {
            JarFile jarFile = null;
            try {
                jarFile = new JarFile(jarFileName);
                JarEntry jarEntry = jarFile.getJarEntry("Lib/os.py");
                standalone = jarEntry != null;
            } catch (IOException ioe) {
                // Continue
            } finally {
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (IOException e) {
                        // Continue
                    }
                }
            }
        }
        return standalone;
    }

    /**
     * @return the full name of the jar file containing this class, <code>null</code> if not
     *         available.
     */
    private static String getJarFileName() {
        Class<PySystemState> thisClass = PySystemState.class;
        String fullClassName = thisClass.getName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        URL url = thisClass.getResource(className + ".class");
        return getJarFileNameFromURL(url);
    }

    protected static String getJarFileNameFromURL(URL url) {
        String jarFileName = null;
        if (url != null) {
            try {
                // escape plus signs, since the URLDecoder would turn them into spaces
                final String plus = "\\+";
                final String escapedPlus = "__ppluss__";
                String rawUrl = url.toString();
                rawUrl = rawUrl.replaceAll(plus, escapedPlus);
                String urlString = URLDecoder.decode(rawUrl, "UTF-8");
                urlString = urlString.replaceAll(escapedPlus, plus);
                int jarSeparatorIndex = urlString.lastIndexOf(JAR_SEPARATOR);
                if (urlString.startsWith(JAR_URL_PREFIX) && jarSeparatorIndex > 0) {
                    // jar:file:/install_dir/jython.jar!/org/python/core/PySystemState.class
                    jarFileName = urlString.substring(JAR_URL_PREFIX.length(), jarSeparatorIndex);
                } else if (urlString.startsWith(VFSZIP_PREFIX)) {
                    // vfszip:/some/path/jython.jar/org/python/core/PySystemState.class
                    final String path = PySystemState.class.getName().replace('.', '/');
                    int jarIndex = urlString.indexOf(".jar/".concat(path));
                    if (jarIndex > 0) {
                        jarIndex += 4;
                        int start = VFSZIP_PREFIX.length();
                        if (Platform.IS_WINDOWS) {
                            // vfszip:/C:/some/path/jython.jar/org/python/core/PySystemState.class
                            start++;
                        }
                        jarFileName = urlString.substring(start, jarIndex);
                    }
                } else if (urlString.startsWith(VFS_PREFIX)) {
                    // vfs:/some/path/jython.jar/org/python/core/PySystemState.class
                    final String path = PySystemState.class.getName().replace('.', '/');
                    int jarIndex = urlString.indexOf(".jar/".concat(path));
                    if (jarIndex > 0) {
                        jarIndex += 4;
                        int start = VFS_PREFIX.length();
                        if (Platform.IS_WINDOWS) {
                            // vfs:/C:/some/path/jython.jar/org/python/core/PySystemState.class
                            start++;
                        }
                        jarFileName = urlString.substring(start, jarIndex);
                    }
                }
            } catch (Exception e) {}
        }
        return jarFileName;
    }

    private static void addPaths(PyList path, String pypath) {
        StringTokenizer tok = new StringTokenizer(pypath, java.io.File.pathSeparator);
        while (tok.hasMoreTokens()) {
            path.append(new PyUnicode(tok.nextToken().trim()));
        }
    }

    public static PyJavaPackage add_package(String n) {
        return add_package(n, null);
    }

    public static PyJavaPackage add_package(String n, String contents) {
        return packageManager.makeJavaPackage(n, contents, null);
    }

    /**
     * Add a classpath directory to the list of places that are searched for java packages.
     * <p>
     * <b>Note</b>. Classes found in directory and sub-directory are not made available to jython by
     * this call. It only makes the java package found in the directory available. This call is
     * mostly useful if jython is embedded in an application that deals with its own class loaders.
     * A servlet container is a very good example. Calling add_classdir("<context>/WEB-INF/classes")
     * makes the java packages in WEB-INF classes available to jython import. However the actual
     * classloading is completely handled by the servlet container's context classloader.
     */
    public static void add_classdir(String directoryPath) {
        packageManager.addDirectory(new File(directoryPath));
    }

    /**
     * Add a .jar & .zip directory to the list of places that are searched for java .jar and .zip
     * files. The .jar and .zip files found will not be cached.
     * <p>
     * <b>Note</b>. Classes in .jar and .zip files found in the directory are not made available to
     * jython by this call. See the note for add_classdir(dir) for more details.
     *
     * @param directoryPath The name of a directory.
     *
     * @see #add_classdir
     */
    public static void add_extdir(String directoryPath) {
        packageManager.addJarDir(directoryPath, false);
    }

    /**
     * Add a .jar & .zip directory to the list of places that are searched for java .jar and .zip
     * files.
     * <p>
     * <b>Note</b>. Classes in .jar and .zip files found in the directory are not made available to
     * jython by this call. See the note for add_classdir(dir) for more details.
     *
     * @param directoryPath The name of a directory.
     * @param cache Controls if the packages in the zip and jar file should be cached.
     *
     * @see #add_classdir
     */
    public static void add_extdir(String directoryPath, boolean cache) {
        packageManager.addJarDir(directoryPath, cache);
    }

    // Not public by design. We can't rebind the displayhook if
    // a reflected function is inserted in the class dict.

    static void displayhook(PyObject o) {
        /* Print value except if None */
        /* After printing, also assign to '_' */
        /* Before, set '_' to None to avoid recursion */
        if (o == Py.None) {
            return;
        }

        PyObject currentBuiltins = Py.getSystemState().getBuiltins();
        currentBuiltins.__setitem__("_", Py.None);
        Py.stdout.println(o.__repr__());
        currentBuiltins.__setitem__("_", o);
    }

    static void excepthook(PyObject type, PyObject val, PyObject tb) {
        PyBaseException value = null;
        if (val != Py.None) value = (PyBaseException) val;
        Py.PyErr_Display(type, value, tb);
    }

    public static PyTuple exc_info() {
        PyException exc = Py.getThreadState().exceptions.peek();
        if (exc == null) {
            return new PyTuple(Py.None, Py.None, Py.None);
        }
        PyObject tb = exc.traceback;
        PyObject value = exc.value;
        return new PyTuple(exc.type, value == null ? Py.None : value, tb == null ? Py.None : tb);
    }

    public static void exc_clear() {
        Py.getThreadState().exceptions.clear();
    }

    public void cleanup() {
        closer.cleanup();
    }

    public void close() { cleanup(); }

    private void initstdio() {
        String mode = Options.unbuffered ? "b" : "";
        int buffering = Options.unbuffered ? 0 : 1;
        PyObject stdin = new PyFile(System.in, "<stdin>", "r" + mode, buffering, false);
        PyObject stdout = new PyFile(System.out, "<stdout>", "w" + mode, buffering, false);
        PyObject stderr = new PyFile(System.err, "<stderr>", "w" + mode, 0, false);

        SysModule.setObject("stdin", stdin);
        SysModule.setObject("__stdin__", stdin);
        SysModule.setObject("stdout", stdout);
        SysModule.setObject("__stdout__", stdout);
        SysModule.setObject("stderr", stderr);
        SysModule.setObject("__stderr__", stderr);
//        String mode = Options.unbuffered ? "b" : "";
//        int buffering = Options.unbuffered ? 0 : 1;
//        imp.load("encodings.utf_8");
//        imp.load("encodings.latin_1");
//        PyObject iomod = imp.load("io");
//        PyObject bimod = imp.load("builtins");
//        PyObject wrapper = iomod.__getattr__("OpenWrapper");
//        /** set builtins.open */
//        bimod.__setattr__("open", wrapper);
//        String encoding = registry.getProperty(PYTHON_IO_ENCODING);
//        if (encoding == null) {
//            encoding = "utf-8";
//        }
//        String errors = registry.getProperty(PYTHON_IO_ERRORS);
//        if (errors == null) {
//            errors = "strict";
//        }
//        __stdin__ = new PyFileIO(new org.jpp.heart.io.BufferedReader(new StreamIO(System.in, false),
//                        IOBase.DEFAULT_BUFFER_SIZE), OpenMode.R_ONLY);
//        stdin = __stdin__ = create_stdtio(iomod, __stdin__, false, "<stdin>", encoding, errors);
//        __stdout__ = new PyFileIO(new org.jpp.heart.io.BufferedWriter(new StreamIO(System.out, false),
//                IOBase.DEFAULT_BUFFER_SIZE), OpenMode.W_ONLY);
//        stdout = __stdout__ = create_stdtio(iomod, __stdout__, true, "<stdout>", encoding, errors);
//        __stderr__ = new PyFileIO(new org.jpp.heart.io.BufferedWriter(new StreamIO(System.err, false),
//                IOBase.DEFAULT_BUFFER_SIZE), OpenMode.W_ONLY);
//        stderr = __stderr__ = create_stdtio(iomod, __stderr__, true, "<stderr>", encoding, errors);
    }
//
//    private static PyObject create_stdtio(PyObject io, PyObject fd, boolean writeMode, String name, String encoding, String errors) {
//        String mode = writeMode ? "wb" : "rb";
//        PyObject buffering = Options.unbuffered ? Py.Zero : Py.One;
//        PyObject buf = io.invoke("open", new PyObject[] {fd, new PyUnicode(mode), buffering, Py.None, Py.None, Py.None, Py.False});
//        buf.__setattr__("__name__", new PyUnicode(name));
//        PyObject stream = io.invoke("TextIOWrapper", new PyObject[] {buf, new PyUnicode(encoding), new PyUnicode(errors), Py.None, Py.False});
//        mode = writeMode ? "w" : "r";
//        stream.__setattr__("mode", new PyUnicode(mode));
//        return stream;
//    }

    public static class PySystemStateCloser {

        private final Set<Callable<Void>> resourceClosers = new LinkedHashSet<Callable<Void>>();
        private volatile boolean isCleanup = false;
        private final Thread shutdownHook;

        private PySystemStateCloser(PySystemState sys) {
            shutdownHook = initShutdownCloser();
            WeakReference<PySystemState> ref =
                    new WeakReference<PySystemState>(sys, systemStateQueue);
            sysClosers.put(ref, this);
            cleanupOtherClosers();
        }

        private static void cleanupOtherClosers() {
            Reference<? extends PySystemState> ref;
            while ((ref = systemStateQueue.poll()) != null) {
                PySystemStateCloser closer = sysClosers.get(ref);
                closer.cleanup();
            }
        }

        private void registerCloser(Callable<Void> closer) {
            synchronized (PySystemStateCloser.class) {
                if (!isCleanup) {
                    resourceClosers.add(closer);
                }
            }
        }

        private boolean unregisterCloser(Callable<Void> closer) {
            synchronized (PySystemStateCloser.class) {
                return resourceClosers.remove(closer);
            }
        }

        private synchronized void cleanup() {
            synchronized (PySystemStateCloser.class) {
                if (isCleanup) {
                    return;
                }
                isCleanup = true;

                // close this thread so we can unload any associated classloaders in cycle
                // with this instance
                if (shutdownHook != null) {
                    try {
                        Runtime.getRuntime().removeShutdownHook(shutdownHook);
                    } catch (IllegalStateException e) {
                        // JVM is already shutting down, so we cannot remove this shutdown hook anyway
                    }
                }

                // Close the listed resources (and clear the list)
                runClosers();
                resourceClosers.clear();

                // XXX Not sure this is ok, but it makes repeat testing possible.
                // Re-enable the management of resource closers
                isCleanup = false;
            }
        }
        private void runClosers() {
            synchronized (PySystemStateCloser.class) {
                // resourceClosers can be null in some strange cases
                if (resourceClosers != null) {
                    /*
                     * Although a Set, the container iterates in the order closers were added. Make a Deque
                     * of it and deal from the top.
                     */
                    LinkedList<Callable<Void>> rc = new LinkedList<Callable<Void>>(resourceClosers);
                    Iterator<Callable<Void>> iter = rc.descendingIterator();

                    while (iter.hasNext()) {
                        Callable<Void> callable = iter.next();
                        try {
                            callable.call();
                        } catch (Exception e) {
                            // just continue, nothing we can do
                        }
                    }
                }
            }
        }

        // Python scripts expect that files are closed upon an orderly cleanup of the VM.
        private Thread initShutdownCloser() {
            try {
                Thread shutdownHook = new Thread(new ShutdownCloser(), "Jython Shutdown Closer");
                Runtime.getRuntime().addShutdownHook(shutdownHook);
                return shutdownHook;
            } catch (SecurityException se) {
                Py.writeDebug("PySystemState", "Can't register cleanup closer hook");
                return null;
            }
        }

        private class ShutdownCloser implements Runnable {

            @Override
            public void run() {
                synchronized (PySystemStateCloser.class) {
                    runClosers();
                    resourceClosers.clear();
                }
            }
        }

    }


    /* Traverseproc implementation */
    @Override
    public int traverse(Visitproc visit, Object arg) {
        int retVal;
        if (argv != null) {
            retVal = visit.visit(argv, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (modules != null) {
            retVal = visit.visit(modules, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (path != null) {
            retVal = visit.visit(path, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (warnoptions != null) {
            retVal = visit.visit(warnoptions, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (builtins != null) {
            retVal = visit.visit(builtins, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (platform != null) {
            retVal = visit.visit(platform, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (meta_path != null) {
            retVal = visit.visit(meta_path, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (path_hooks != null) {
            retVal = visit.visit(path_hooks, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (path_importer_cache != null) {
            retVal = visit.visit(path_importer_cache, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (ps1 != null) {
            retVal = visit.visit(ps1, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (ps2 != null) {
            retVal = visit.visit(ps2, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (executable != null) {
            retVal = visit.visit(executable, arg);
            if (retVal != 0) {
                return retVal;
            }
        }

        if (__displayhook__ != null) {
            retVal = visit.visit(__displayhook__, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (__excepthook__ != null) {
            retVal = visit.visit(__excepthook__, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (last_value != null) {
            retVal = visit.visit(last_value, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (last_type != null) {
            retVal = visit.visit(last_type, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (last_traceback != null) {
            retVal = visit.visit(last_traceback, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (__name__ != null) {
            retVal = visit.visit(__name__, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        return __dict__ == null ? 0 : visit.visit(__dict__, arg);
    }

    @Override
    public boolean refersDirectlyTo(PyObject ob) {
        return ob != null && (ob == argv || ob ==  modules || ob == path
            || ob == warnoptions || ob == builtins || ob == platform
            || ob == meta_path || ob == path_hooks || ob == path_importer_cache
            || ob == ps1 || ob == ps2 || ob == executable
            || ob == __displayhook__ || ob == __excepthook__
            || ob ==  last_value || ob == last_type || ob == last_traceback
            || ob ==__name__ || ob == __dict__);
    }


    /**
     * Helper abstracting common code from {@link ShutdownCloser#run()} and
     * {@link PySystemStateCloser#cleanup()} to close resources (such as still-open files). The
     * closing sequence is from last-created resource to first-created, so that dependencies between
     * them are respected. (There are some amongst layers in the _io module.)
     *
     * @param resourceClosers to be called in turn
     */
}


@Untraversable
class PySystemStateFunctions extends PyBuiltinFunctionSet {

    PySystemStateFunctions(String name, int index, int minargs, int maxargs) {
        super(name, index, minargs, maxargs);
    }

    @Override
    public PyObject __call__(PyObject arg) {
        switch (index) {
            case 10:
                PySystemState.displayhook(arg);
                return Py.None;
            default:
                throw info.unexpectedCall(1, false);
        }
    }

    @Override
    public PyObject __call__(PyObject arg1, PyObject arg2, PyObject arg3) {
        switch (index) {
            case 30:
                PySystemState.excepthook(arg1, arg2, arg3);
                return Py.None;
            default:
                throw info.unexpectedCall(3, false);
        }
    }
}


/**
 * Value of a class or instance variable when the corresponding attribute is deleted. Used only in
 * PySystemState for now.
 */
@Untraversable
class PyAttributeDeleted extends PyObject {

    final static PyAttributeDeleted INSTANCE = new PyAttributeDeleted();

    private PyAttributeDeleted() {}

    @Override
    public String toString() {
        return "";
    }

    @Override
    public Object __tojava__(Class c) {
        if (c == PyObject.class) {
            return this;
        }
        // we can't quite "delete" non-PyObject attributes; settle for
        // null or nothing
        if (c.isPrimitive()) {
            return Py.NoConversion;
        }
        return null;
    }
}


@ExposedType(name = "sys.float_info", isBaseType = false)
class FloatInfo extends PyTuple {

    @ExposedGet
    public PyObject max, max_exp, max_10_exp, min, min_exp, min_10_exp, dig, mant_dig, epsilon,
            radix, rounds;

    public static final PyType TYPE = PyType.fromClass(FloatInfo.class);

    private FloatInfo(PyObject... vals) {
        super(TYPE, vals);

        max = vals[0];
        max_exp = vals[1];
        max_10_exp = vals[2];
        min = vals[3];
        min_exp = vals[4];
        min_10_exp = vals[5];
        dig = vals[6];
        mant_dig = vals[7];
        epsilon = vals[8];
        radix = vals[9];
        rounds = vals[10];
    }

    static public FloatInfo getInfo() {
        // max_10_exp, dig and epsilon taken from ssj library Num class
        // min_10_exp, mant_dig, radix and rounds by ɲeuroburɳ (bit.ly/Iwo2LT)
        return new FloatInfo( //
                Py.newFloat(Double.MAX_VALUE),       // DBL_MAX
                Py.newLong(Double.MAX_EXPONENT),     // DBL_MAX_EXP
                Py.newLong(308),                     // DBL_MIN_10_EXP
                Py.newFloat(Double.MIN_VALUE),       // DBL_MIN
                Py.newLong(Double.MIN_EXPONENT),     // DBL_MIN_EXP
                Py.newLong(-307),                    // DBL_MIN_10_EXP
                Py.newLong(10),                      // DBL_DIG
                Py.newLong(53),                      // DBL_MANT_DIG
                Py.newFloat(2.2204460492503131e-16), // DBL_EPSILON
                Py.newLong(2),                       // FLT_RADIX
                Py.newLong(1)                        // FLT_ROUNDS
        );
    }


    /* Traverseproc implementation */
    @Override
    public int traverse(Visitproc visit, Object arg) {
        int retVal = super.traverse(visit, arg);
        if (max != null) {
            retVal = visit.visit(max, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (max_exp != null) {
            retVal = visit.visit(max_exp, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (max_10_exp != null) {
            retVal = visit.visit(max_10_exp, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (min != null) {
            retVal = visit.visit(min, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (min_exp != null) {
            retVal = visit.visit(min_exp, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (min_10_exp != null) {
            retVal = visit.visit(min_10_exp, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (dig != null) {
            retVal = visit.visit(dig, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (mant_dig != null) {
            retVal = visit.visit(mant_dig, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (epsilon != null) {
            retVal = visit.visit(epsilon, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (radix != null) {
            retVal = visit.visit(radix, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        return rounds == null ? 0 : visit.visit(rounds, arg);
    }

    @Override
    public boolean refersDirectlyTo(PyObject ob) {
        return ob != null && (ob == max || ob == max_exp || ob == max_10_exp || ob == min
            || ob == min_exp || ob == min_10_exp || ob == dig
            || ob == mant_dig || ob == epsilon || ob == radix || ob == rounds);
    }
}


@ExposedType(name = "sys.long_info", isBaseType = false)
class LongInfo extends PyTuple {

    @ExposedGet
    public PyObject bits_per_digit, sizeof_digit;

    public static final PyType TYPE = PyType.fromClass(LongInfo.class);

    private LongInfo(PyObject... vals) {
        super(TYPE, vals);

        bits_per_digit = vals[0];
        sizeof_digit = vals[1];
    }

    // XXX: I've cheated and just used the values that CPython gives me for my
    // local Ubuntu system. I'm not sure that they are correct.
    static public LongInfo getInfo() {
        return new LongInfo(Py.newLong(30), Py.newLong(4));
    }

    /* Traverseproc implementation */
    @Override
    public int traverse(Visitproc visit, Object arg) {
        int retVal = super.traverse(visit, arg);
        if (bits_per_digit != null) {
            retVal = visit.visit(bits_per_digit, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        return sizeof_digit == null ? 0 : visit.visit(sizeof_digit, arg);
    }

    @Override
    public boolean refersDirectlyTo(PyObject ob) {
        return ob != null && (ob == bits_per_digit || ob == sizeof_digit);
    }
}
