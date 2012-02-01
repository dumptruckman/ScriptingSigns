package com.dumptruckman.scriptingsigns.sign;

import com.dumptruckman.actionmenu2.api.Menu;
import com.dumptruckman.actionmenu2.api.MenuHandle;
import com.dumptruckman.actionmenu2.api.MenuItem;
import com.dumptruckman.actionmenu2.api.event.MenuItemListener;
import com.dumptruckman.actionmenu2.impl.Menus;
import com.dumptruckman.actionmenu2.impl.SimpleMenuItem;
import com.dumptruckman.scriptingsigns.menu.SaveExitListener;
import com.dumptruckman.scriptingsigns.menu.SignView;
import com.dumptruckman.scriptingsigns.menu.ViewEditListener;
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
        MenuHandle handle = Menus.newMenuHandle(this.plugin);
        handle.addView(new SignView(this.plugin, sign));
        ScriptSign scriptSign = new DefaultScriptSign(sign, owner, handle);
        setupMainMenu(scriptSign);
        this.blockScriptSignMap.put(BlockLocation.get(sign.getBlock()), scriptSign);
        return scriptSign;
    }
    
    public ScriptSign getSign(Block block) {
        return this.blockScriptSignMap.get(BlockLocation.get(block));
    }
    
    private void setupMainMenu(MenuHandle menuHandle) {
        MenuItem item = new SimpleMenuItem(this.plugin);
        item.setText("Scripting Sign");
        item.setSelectable(false);
        menuHandle.getContents().add(item);
        item = new SimpleMenuItem(this.plugin);
        item.setText("View/Edit");
        item.getMenuItemListeners().add(
                new ViewEditListener(menuHandle,
                        this.newViewEditMenu(menuHandle)));
        menuHandle.getContents().add(item);
    }

    private Menu newViewEditMenu(MenuHandle menuHandle) {
        Menu menu = Menus.newMenu(this.plugin);
        MenuItem item = new SimpleMenuItem(this.plugin);
        item.setText("Edit Script:");
        item.setSelectable(false);
        menu.getContents().add(item);
        item = new SimpleMenuItem(this.plugin);
        item.setText("<new line>");
        // Add listener
        menu.getContents().add(item);
        item = new SimpleMenuItem(this.plugin);
        item.setText("<save and exit>");
        item.getMenuItemListeners().add(
                new SaveExitListener(menuHandle, menuHandle.getMenu()));
        menu.getContents().add(item);
        return menu;
    }
}
