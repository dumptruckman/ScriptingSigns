package com.dumptruckman.scriptingsigns.menu;

import com.dumptruckman.actionmenu2.api.Menu;
import com.dumptruckman.actionmenu2.api.MenuModel;
import com.dumptruckman.actionmenu2.api.event.MenuItemEvent;
import com.dumptruckman.actionmenu2.api.event.MenuItemListener;
import com.dumptruckman.scriptingsigns.sign.ScriptSign;

public class SaveExitListener implements MenuItemListener {

    private ScriptSign scriptSign;
    private MenuModel mainMenu;

    public SaveExitListener(ScriptSign scriptSign, MenuModel mainMenu) {
        this.scriptSign = scriptSign;
        this.mainMenu = mainMenu;
    }

    @Override
    public void onAction(MenuItemEvent menuItemEvent) {
        this.scriptSign.setModel(this.mainMenu);
    }

    @Override
    public void onMenuItemChange(MenuItemEvent menuItemEvent) { }
}
