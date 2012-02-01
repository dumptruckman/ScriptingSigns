package com.dumptruckman.scriptingsigns.sign;

import com.dumptruckman.actionmenu2.api.MenuHandle;
import com.dumptruckman.actionmenu2.impl.Menus;
import com.dumptruckman.scriptingsigns.menu.SignView;
import com.dumptruckman.scriptingsigns.sign.DefaultScriptSign;
import com.dumptruckman.scriptingsigns.sign.ScriptSign;
import com.dumptruckman.scriptingsigns.util.BlockLocation;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class Signs {

    private Plugin plugin;
    
    private Map<BlockLocation, ScriptSign> blockScriptSignMap = new HashMap<BlockLocation, ScriptSign>();

    public Signs(Plugin plugin) {
        this.plugin = plugin;
    }
    
    public ScriptSign newSign(Sign sign, Player owner) {
        MenuHandle handle = Menus.newMenuHandle(this.plugin, sign, SignView.class);
        ScriptSign scriptSign = new DefaultScriptSign(sign, owner, handle);
        this.blockScriptSignMap.put(BlockLocation.get(sign.getBlock()), scriptSign);
        return scriptSign;
    }
    
    public ScriptSign getSign(Block block) {
        return this.blockScriptSignMap.get(BlockLocation.get(block));
    }
}
