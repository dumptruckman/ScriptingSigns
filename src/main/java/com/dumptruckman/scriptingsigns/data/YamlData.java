package com.dumptruckman.scriptingsigns.data;

import com.dumptruckman.scriptingsigns.util.Logging;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

/**
 * Implementation of MVIData.
 */
public class YamlData implements Data {

    private static final String YML = ".yml";
    private File dataFile = null;

    public YamlData(JavaPlugin plugin) throws IOException {
        // Make the data folders
        if (plugin.getDataFolder().mkdirs()) {
            Logging.debug("Created data folder.");
        }

        // Check if the config file exists.  If not, create it.
        dataFile = new File(plugin.getDataFolder(), "data.yml");
        if (!dataFile.exists()) {
            if (!dataFile.createNewFile()) {
                throw new IOException("Could not create data file!");
            }
        }
    }
}
