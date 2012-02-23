package com.dumptruckman.scriptingsigns.sign;

import com.dumptruckman.actionmenu2.api.Menu;
import com.dumptruckman.actionmenu2.api.MenuItem;
import com.dumptruckman.actionmenu2.api.MenuModel;
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
        setupMainMenu(scriptSign);
        this.blockScriptSignMap.put(BlockLocation.get(sign.getBlock()), scriptSign);
        return scriptSign;
    }
    
    public ScriptSign getSign(Block block) {
        return this.blockScriptSignMap.get(BlockLocation.get(block));
    }
    
    private void setupMainMenu(ScriptSign scriptSign) {
        MenuModel mainMenuModel = scriptSign.getModel();
        MenuItem item = new SimpleMenuItem();
        item.setText("Scripting Sign");
        item.setSelectable(false);
        scriptSign.getModel().add(item);
        item = new SimpleMenuItem();
        item.setText("View/Edit");
        item.getMenuItemListeners().add(
                new ViewEditListener(scriptSign,
                        this.newViewEditMenu(scriptSign, mainMenuModel)));
        scriptSign.getModel().add(item);
        item = new SimpleMenuItem();
        item.setText("really big big big long text line");
        // Add listener
        scriptSign.getModel().add(item);
    }

    private MenuModel newViewEditMenu(ScriptSign scriptSign, MenuModel mainMenu) {
        MenuModel menu = Menus.newMenuModel();
        MenuItem item = new SimpleMenuItem();
        item.setText("Edit Script:");
        item.setSelectable(false);
        menu.add(item);
        item = new SimpleMenuItem();
        item.setText("<new line 1>");
        // Add listener
        menu.add(item);
        item = new SimpleMenuItem();
        item.setText("<new line 2>");
        // Add listener
        menu.add(item);
        item = new SimpleMenuItem();
        item.setText("<new line 3>");
        // Add listener
        menu.add(item);
        item = new SimpleMenuItem();
        item.setText("<new line 4 extra long test>");
        // Add listener
        menu.add(item);
        item = new SimpleMenuItem();
        item.setText("<save and exit>");
        item.getMenuItemListeners().add(
                new SaveExitListener(scriptSign, mainMenu));
        menu.add(item);
        return menu;
    }
}
