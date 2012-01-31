package com.dumptruckman.scriptingsigns.menu;

import com.dumptruckman.actionmenu2.api.AbstractSignView;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SignView extends AbstractSignView {
    
    public SignView(Plugin plugin, Sign sign) {
        super(plugin, sign);
    }
    
    @Override
    public void show(Player player) {
        
    }
}
