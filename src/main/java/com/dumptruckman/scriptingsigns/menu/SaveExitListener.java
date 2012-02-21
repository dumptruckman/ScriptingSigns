package com.dumptruckman.scriptingsigns.menu;

import com.dumptruckman.actionmenu2.api.Menu;
import com.dumptruckman.actionmenu2.api.event.MenuItemEvent;
import com.dumptruckman.actionmenu2.api.event.MenuItemListener;

public class SaveExitListener implements MenuItemListener {

    private Menu menuHandle;
    private Menu mainMenu;

    public SaveExitListener(Menu menuHandle, Menu mainMenu) {
        this.menuHandle = menuHandle;
        this.mainMenu = mainMenu;
    }

    @Override
    public void onAction(MenuItemEvent menuItemEvent) {
        this.menuHandle.setModel(this.mainMenu.getModel());
    }

    @Override
    public void onMenuItemChange(MenuItemEvent menuItemEvent) { }
}
