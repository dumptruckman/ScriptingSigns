package com.dumptruckman.scriptingsigns.sign;

import com.dumptruckman.actionmenu2.api.Menu;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public interface ScriptSign extends Menu {

    Block getBlock();

    Sign getSign();

    Player getOwner();

}
