package com.dumptruckman.scriptingsigns;

import com.dumptruckman.scriptingsigns.permission.Perm;
import com.dumptruckman.scriptingsigns.sign.ScriptSign;
import com.dumptruckman.scriptingsigns.sign.Signs;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

/**
 * Class that handles all bukkit events for this Plugin.
 */
public class PluginListener implements Listener {

    private ScriptingSigns plugin;

    public PluginListener(ScriptingSigns plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void signChange(SignChangeEvent event) {
        if (event.isCancelled()) {
            return;
        }
        if (!Perm.CAN_CREATE.has(event.getPlayer())) {
            return;
        }
        boolean found = false;
        for (String createString : this.plugin.getSettings().getSignCreationPhrases()) {
            for (String line : event.getLines()) {
                if (line.toLowerCase().contains(createString.toLowerCase())) {
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            return;
        }
        ScriptSign scriptSign = this.plugin.getSigns().newSign(
                (Sign) event.getBlock().getState(), event.getPlayer());
    }
}
