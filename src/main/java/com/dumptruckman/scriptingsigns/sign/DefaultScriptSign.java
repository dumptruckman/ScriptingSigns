package com.dumptruckman.scriptingsigns.sign;

import com.dumptruckman.actionmenu2.api.MenuHandle;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class DefaultScriptSign implements ScriptSign {
    
    private Block block;
    private Sign sign;
    private Player owner;
    private MenuHandle menuHandle;
    
    protected DefaultScriptSign(Sign sign, Player owner, MenuHandle menuHandle) {
        this.block = sign.getBlock();
        this.sign = sign;
        this.owner = owner;
        this.menuHandle = menuHandle;
    }

    @Override
    public Block getBlock() {
        return block;
    }

    @Override
    public Sign getSign() {
        return sign;
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public MenuHandle getMenuHandle() {
        return menuHandle;
    }
}
