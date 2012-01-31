package com.dumptruckman.scriptingsigns.sign;

import com.dumptruckman.actionmenu2.api.MenuHandle;
import com.dumptruckman.actionmenu2.impl.Menus;
import com.dumptruckman.scriptingsigns.menu.SignView;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Signs {

    private Signs() { }
    
    public static ScriptingSign newSign(Plugin plugin, Sign sign, Player owner) {
        MenuHandle handle = Menus.newMenuHandle(plugin, Menus.newMenu(plugin));
        handle.addView(new SignView(plugin, sign));
        return new DefaultScriptingSign(sign, owner, handle);
    }
    
    public static ScriptingSign getSign(Block block) {
        return null;
    }
}
