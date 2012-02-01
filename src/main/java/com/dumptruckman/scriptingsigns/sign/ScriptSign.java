package com.dumptruckman.scriptingsigns.sign;

import com.dumptruckman.actionmenu2.api.MenuHandle;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public interface ScriptSign {

    Block getBlock();

    Sign getSign();

    Player getOwner();

    MenuHandle getMenuHandle();
}
