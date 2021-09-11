// Copyright (c) Corporation for National Research Initiatives
package org.jpp.modules;

// This is sort of analogous to CPython's Modules/Setup file.  Use this to
// specify additional builtin org.jpp.modules.

public class Setup {
    // Each element of this array is a string naming a builtin module to
    // add to the system.  The string has the following allowable forms:
    //
    // name
    //     The module name is `name' and the class name is
    //     org.python.org.jpp.modules.name
    //
    // name:class
    //     The module name is `name' and the class name is `class' where
    //     class must be a fully qualified Java class name
    //
    // name:null
    //     The module `name' is removed from the list of builtin org.jpp.modules
    //
    // That isn't very useful here, but you can add additional builtin
    // org.jpp.modules by editing the Jython registry file.  See the property
    // python.org.jpp.modules.builtin for details.

    public static String[] builtinModules = {
            "_bytecodetools",
//            "_codecs",
            "_hashlib",
            "_io:org.python.org.jpp.modules._io._io",
            "_json:org.python.org.jpp.modules._json._json",
            "_jythonlib:org.python.org.jpp.modules._jythonlib._jythonlib",
            "_random:org.python.org.jpp.modules.random.RandomModule",
//            "_sre",
//            "_string",
            "_systemrestart",
//            "_types",
//            "_weakref:org.python.org.jpp.modules._weakref.WeakrefModule",
            "_pickle",
            "cmath",
            "errno",
            "fcntl",
            "gc",
            "jarray",
            "jffi:org.python.org.jpp.modules.jffi.jffi",
            "marshal",
            "math",
            "operator",
            "struct",
            "synchronize",
//            "_thread:org.python.org.jpp.modules.thread.thread",
//            PosixModule.getOSName() + ":org.python.org.jpp.modules.posix.PosixModule"
    };

    public static String[] newbuiltinModules = {
            "_ast:org.jpp.astnodes.ast.AstModule",
            "_bz2:org.python.org.jpp.modules.bz2.bz2",
            "_codecs",
            "_codecs_cn:org.python.org.jpp.modules.cjkcodecs._codecs_cn",
            "_codecs_tw:org.python.org.jpp.modules.cjkcodecs._codecs_tw",
            "_codecs_hk:org.python.org.jpp.modules.cjkcodecs._codecs_hk",
            "_codecs_kr:org.python.org.jpp.modules.cjkcodecs._codecs_kr",
            "_codecs_jp:org.python.org.jpp.modules.cjkcodecs._codecs_jp",
            "_collections:org.python.org.jpp.modules._collections.Collections",
            "_csv:org.python.org.jpp.modules._csv._csv",
            "_datetime:org.python.org.jpp.modules._datetime.DatetimeModule",
            "_functools:org.python.org.jpp.modules._functools._functools",
            "_imp:org.python.org.jpp.modules._imp",
            "_multibytecodec:org.python.org.jpp.modules.cjkcodecs._multibytecodec",
            "_multiprocessing:org.python.org.jpp.modules._multiprocessing._multiprocessing",
            "_posixsubprocess",
            "_sre",
            "_string",
            "_types",
            "_thread:org.python.org.jpp.modules.thread._thread",
            "_warnings",
            "_weakref:org.python.org.jpp.modules._weakref.WeakrefModule",
            "array:org.python.org.jpp.modules.ArrayModule",
            "binascii",
            "faulthandler:org.python.org.jpp.modules.FaultHandler",
            "itertools:org.python.org.jpp.modules.itertools.itertools",
            "posix:org.python.org.jpp.modules.posix.PosixModule",
            "subprocess:org.python.org.jpp.modules.subprocess.SubprocessModule",
            "sys:org.python.org.jpp.modules.sys.SysModule",
            "time:org.python.org.jpp.modules.time.TimeModule",
            "unicodedata:org.python.org.jpp.modules.unicodedata.unicodedata",
            "zipimport:org.python.org.jpp.modules.zipimport.ZipImportModule",
            "zlib:org.python.org.jpp.modules.zlib.ZlibModule",
    };
}
