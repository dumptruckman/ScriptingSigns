package com.dumptruckman.scriptingsigns;

import com.dumptruckman.scriptingsigns.permission.Perm;
import com.dumptruckman.scriptingsigns.sign.ScriptSign;
import com.dumptruckman.scriptingsigns.sign.Signs;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Class that handles all bukkit events for this Plugin.
 */
public class PluginListener implements Listener {

    private ScriptingSigns plugin;

    public PluginListener(ScriptingSigns plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void playerInteract(PlayerInteractEvent event) {
        if (!(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)
                || event.getAction().equals(Action.LEFT_CLICK_BLOCK))) {
            System.out.println("Not block");
            return;
        }
        if (!(event.getClickedBlock().getState() instanceof Sign)) {
            System.out.println("Not sign");
            return;
        }
        ScriptSign sign = this.plugin.getSigns().getSign(event.getClickedBlock());
        if (sign == null) {
            System.out.println("Not scriptsign");
            return;
        }
        sign.touch(event.getPlayer());
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            sign.cycleMenu();
        } else if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            sign.runSelected();
        }
        sign.updateViews(event.getPlayer());
        sign.show(event.getPlayer());
    }

    @EventHandler
    public void signChange(SignChangeEvent event) {
        if (event.isCancelled()) {
            return;
        }
        if (!Perm.CAN_CREATE.has(event.getPlayer())) {
            //return;
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
        scriptSign.touch(event.getPlayer());
        scriptSign.updateViews(event.getPlayer());
        System.out.println("made sign");
    }
}
