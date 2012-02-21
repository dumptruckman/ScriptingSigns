package com.dumptruckman.scriptingsigns.sign;

import com.dumptruckman.actionmenu2.api.Menu;
import com.dumptruckman.actionmenu2.api.MenuItem;
import com.dumptruckman.actionmenu2.api.MenuView;
import com.dumptruckman.actionmenu2.impl.Menus;
import com.dumptruckman.actionmenu2.impl.SimpleMenuItem;
import com.dumptruckman.scriptingsigns.menu.SaveExitListener;
import com.dumptruckman.scriptingsigns.menu.SignView;
import com.dumptruckman.scriptingsigns.menu.ViewEditListener;
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
        Menu handle = Menus.newMenu(this.plugin);
        SignView view = new SignView(this.plugin, sign);
        handle.getViews().add(view);
        ScriptSign scriptSign = new DefaultScriptSign(sign, owner, handle);
        setupMainMenu(scriptSign, view);
        this.blockScriptSignMap.put(BlockLocation.get(sign.getBlock()), scriptSign);
        return scriptSign;
    }
    
    public ScriptSign getSign(Block block) {
        return this.blockScriptSignMap.get(BlockLocation.get(block));
    }
    
    private void setupMainMenu(Menu menuHandle, SignView view) {
        menuHandle.getModel().getMenuContentsListeners().add(view);
        MenuItem item = new SimpleMenuItem();
        item.setText("Scripting Sign");
        item.setSelectable(false);
        menuHandle.getModel().add(item);
        item = new SimpleMenuItem();
        item.setText("View/Edit");
        item.getMenuItemListeners().add(
                new ViewEditListener(menuHandle,
                        this.newViewEditMenu(menuHandle, view)));
        menuHandle.getModel().add(item);
    }

    private Menu newViewEditMenu(Menu menuHandle, SignView view) {
        Menu menu = Menus.newMenu(this.plugin);
        menu.getModel().getMenuContentsListeners().add(view);
        MenuItem item = new SimpleMenuItem();
        item.setText("Edit Script:");
        item.setSelectable(false);
        menu.getModel().add(item);
        item = new SimpleMenuItem();
        item.setText("<new line 1>");
        // Add listener
        menu.getModel().add(item);
        item = new SimpleMenuItem();
        item.setText("<new line 2>");
        // Add listener
        menu.getModel().add(item);
        item = new SimpleMenuItem();
        item.setText("<new line 3>");
        // Add listener
        menu.getModel().add(item);
        item = new SimpleMenuItem();
        item.setText("<new line 4>");
        // Add listener
        menu.getModel().add(item);
        item = new SimpleMenuItem();
        item.setText("<save and exit>");
        item.getMenuItemListeners().add(
                new SaveExitListener(menu, menuHandle));
        menu.getModel().add(item);
        return menu;
    }
}
