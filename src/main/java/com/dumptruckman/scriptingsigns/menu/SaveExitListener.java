package com.dumptruckman.scriptingsigns.menu;

import com.dumptruckman.actionmenu2.api.Menu;
import com.dumptruckman.actionmenu2.api.MenuHandle;
import com.dumptruckman.actionmenu2.api.event.MenuItemEvent;
import com.dumptruckman.actionmenu2.api.event.MenuItemListener;

public class SaveExitListener implements MenuItemListener {

    private MenuHandle menuHandle;
    private Menu mainMenu;

    public SaveExitListener(MenuHandle menuHandle, Menu mainMenu) {
        this.menuHandle = menuHandle;
        this.mainMenu = mainMenu;
    }

    @Override
    public void onAction(MenuItemEvent menuItemEvent) {
        this.menuHandle.setMenu(this.mainMenu);
    }

    @Override
    public void onMenuItemChange(MenuItemEvent menuItemEvent) { }
}
