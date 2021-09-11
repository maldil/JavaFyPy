/* Copyright (c) Jython Developers */
package org.jpp.heart;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Properties;
import java.util.Set;

/**
 * Jython version information.
 *
 * The version number and build information are loaded from the
 * version.properties file, located in this class file's
 * directory. version.properties is generated by ant.
 */
public class Version {

    /** The current version of Jython. */
    public static String PY_VERSION;

    public static String PY_CACHE_TAG;
    /** Tokenized version. */
    public static int PY_MAJOR_VERSION;
    public static int PY_MINOR_VERSION;
    public static int PY_MICRO_VERSION;
    public static int PY_RELEASE_LEVEL;
    public static int PY_RELEASE_SERIAL;

    /** Timestamp of the current build. */
    public static String DATE;
    public static String TIME;

    /** Current hg branch (hg id -b). */
    public static String HG_BRANCH;

    /** Current hg tag (hg id -t), e.g. 'tip'. */
    public static String HG_TAG;

    /** Current hg global revision id (hg id -i). */
    public static String HG_VERSION;

    /** The flags that are set by default in a code object. */
    private static final Collection<CodeFlag> defaultCodeFlags = Arrays.asList(
            CodeFlag.CO_NESTED
//            CodeFlag.CO_GENERATOR_ALLOWED,
//            CodeFlag.CO_FUTURE_WITH_STATEMENT,
//            CodeFlag.CO_FUTURE_ABSOLUTE_IMPORT,
//            CodeFlag.CO_FUTURE_DIVISION,
//            CodeFlag.CO_FUTURE_PRINT_FUNCTION,
//            CodeFlag.CO_FUTURE_UNICODE_LITERALS
    );

    static {
        loadProperties();
    }

    /**
     * Load the version information from the properties file.
     */
    private static void loadProperties() {
        boolean loaded = false;
        final String versionProperties = "/org/python/version.properties";
        InputStream in = Version.class.getResourceAsStream(versionProperties);
        if (in != null) {
            try {
                Properties properties = new Properties();
                properties.load(in);
                loaded = true;
                PY_VERSION = properties.getProperty("jython.version");
                PY_MAJOR_VERSION = Integer.valueOf(properties.getProperty("jython.major_version"));
                PY_MINOR_VERSION = Integer.valueOf(properties.getProperty("jython.minor_version"));
                PY_MICRO_VERSION = Integer.valueOf(properties.getProperty("jython.micro_version"));
                PY_RELEASE_LEVEL = Integer.valueOf(properties.getProperty("jython.release_level"));
                PY_RELEASE_SERIAL = Integer.valueOf(properties.getProperty("jython.release_serial"));
                PY_CACHE_TAG = "$jython-" + PY_MAJOR_VERSION + PY_MINOR_VERSION;
                DATE = properties.getProperty("jython.build.date");
                TIME = properties.getProperty("jython.build.time");
                HG_BRANCH = properties.getProperty("jython.build.hg_branch");
                HG_TAG = properties.getProperty("jython.build.hg_tag");
                HG_VERSION = properties.getProperty("jython.build.hg_version");
            } catch (IOException ioe) {
                System.err.println("There was a problem loading ".concat(versionProperties)
                        .concat(":"));
                ioe.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException ioe) {
                    // ok
                }
            }
        }
        if (!loaded) {
            // fail with a meaningful exception (cannot use Py Exceptions here)
            throw new RuntimeException("unable to load ".concat(versionProperties));
        }
    }

    /**
     * Return the current hg version number. May be an empty string on environments that
     * can't determine it.
     */
    public static String getHGVersion() {
        return HG_VERSION;
    }

    /**
     * Return the current hg identifier name, either the current branch or tag.
     */
    public static String getHGIdentifier() {
        return "".equals(HG_TAG) || "tip".equals(HG_TAG) ? HG_BRANCH : HG_TAG;
    }

    /**
     * Return the current build information, including revision and timestamp.
     */
    public static String getBuildInfo() {
        String revision = getHGVersion();
        String sep = "".equals(revision) ? "" : ":";
        String hgId = getHGIdentifier();
        return String.format("%s%s%s, %.20s, %.9s", hgId, sep, revision, DATE, TIME);
    }

    /**
     * Describe the current Java VM.
     */
    public static String getVM() {
        return String.format("\n[%s (%s)]", System.getProperty("java.vm.name"),
                             System.getProperty("java.vm.vendor"));
    }

    /**
     * Return the Python version, including org.jpp.compiler (or in our case,
     * the Java VM).
     */
    public static String getVersion() {
        return String.format("%.80s (%.80s) %.80s", PY_VERSION, getBuildInfo(), getVM());
    }

    public static Set<CodeFlag> getDefaultCodeFlags() {
        return EnumSet.copyOf(defaultCodeFlags);
    }
}
