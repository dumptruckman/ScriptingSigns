package com.dumptruckman.scriptingsigns.util;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Static plugin logger.
 */
public class Logging {

    // BEGIN CHECKSTYLE-SUPPRESSION: Name
    private static Logger LOG = Logger.getLogger("Minecraft");
    private static String NAME = "ScriptingSigns";
    private static String VERSION = "v.???";
    private static boolean DEBUG_MODE = false;
    // END CHECKSTYLE-SUPPRESSION: Name

    private Logging() {
    }

    /**
     * Prepares the log for use.
     *
     * @param plugin The plugin.
     */
    public static void init(JavaPlugin plugin) {
        PluginDescriptionFile pdf = plugin.getDescription();
        NAME = pdf.getName();
        VERSION = pdf.getVersion();
    }

    /**
     * @param debugMode True to use debug mode.
     */
    public static void setDebugMode(boolean debugMode) {
        Logging.DEBUG_MODE = debugMode;
    }

    /**
     * Adds the plugin name and optionally the version number to the log message.
     *
     * @param message     Log message
     * @param showVersion Whether to show version in log message
     * @return Modified message
     */
    public static String getString(String message, boolean showVersion) {
        String string = "[" + NAME;
        if (showVersion) string += " " + VERSION;
        string = string + "] " + message;
        return string;
    }

    /**
     * Returns the logger object.
     *
     * @return Logger object
     */
    public static Logger getLog() {
        return LOG;
    }

    /**
     * Custom log method.
     *
     * @param level       Log level
     * @param message     Log message
     * @param showVersion True adds version into message
     */
    public static void log(Level level, String message, boolean showVersion) {
        LOG.log(level, getString(message, showVersion));
    }

    /**
     * Returns the Name and Version as a combined string.
     *
     * @return "$Name v$Version"
     */
    public static String getNameVersion() {
        return NAME + " " + VERSION;
    }

    /**
     * Debug level logging.
     *
     * @param message Log message
     */
    public static void debug(String message) {
        if (Logging.DEBUG_MODE) {
            info(message, false);
        }
    }

    /**
     * Info level logging.
     *
     * @param message Log message
     */
    public static void info(String message) {
        info(message, false);
    }

    /**
     * Info level logging.
     *
     * @param message     Log message
     * @param showVersion True adds version into message
     */
    public static void info(String message, boolean showVersion) {
        Logging.log(Level.INFO, message, showVersion);
    }

    /**
     * Info level logging.  Only displays if debug mode is enabled.
     *
     * @param message Log message
     */
    /*public static void debug(String message) {
        if (MultiverseInventories.getConfig().isDebugging()) {
            LOG.info(getString(message, true));
        }
    }*/

    /**
     * Warning level logging.
     *
     * @param message Log message
     */
    public static void warning(String message) {
        warning(message, false);
    }

    /**
     * Warning level logging.
     *
     * @param message     Log message
     * @param showVersion True adds version into message
     */
    public static void warning(String message, boolean showVersion) {
        Logging.log(Level.WARNING, message, showVersion);
    }

    /**
     * Severe level logging.
     *
     * @param message Log message
     */
    public static void severe(String message) {
        severe(message, false);
    }

    /**
     * Severe level logging.
     *
     * @param message     Log message
     * @param showVersion True adds version into message
     */
    public static void severe(String message, boolean showVersion) {
        Logging.log(Level.SEVERE, message, showVersion);
    }

}


