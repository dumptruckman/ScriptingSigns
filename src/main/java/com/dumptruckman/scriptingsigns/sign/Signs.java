package com.dumptruckman.scriptingsigns.sign;

import com.dumptruckman.actionmenu2.api.MenuHandle;
import com.dumptruckman.actionmenu2.api.Menus;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class Signs {

    private Signs() { }
    
    public static ScriptingSign newSign(Sign sign, Player owner) {
        MenuHandle handle = Menus.getMenuHandle(sign);
        handle.getView().setMenu(handle.getMenu());
        return new DefaultScriptingSign(sign, owner, handle);
    }
    
    public static ScriptingSign getSign(Block block) {
        return null;
    }
}
