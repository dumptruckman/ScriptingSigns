package com.dumptruckman.scriptingsigns.sign;

import com.dumptruckman.actionmenu2.api.MenuHandle;
import com.dumptruckman.actionmenu2.api.MenuView;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public interface ScriptSign extends MenuHandle {

    Block getBlock();

    Sign getSign();

    Player getOwner();

    MenuHandle getMenuHandle();
}
