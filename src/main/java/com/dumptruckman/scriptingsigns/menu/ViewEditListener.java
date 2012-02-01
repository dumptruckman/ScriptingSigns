package com.dumptruckman.scriptingsigns.menu;

import com.dumptruckman.actionmenu2.api.Menu;
import com.dumptruckman.actionmenu2.api.MenuHandle;
import com.dumptruckman.actionmenu2.api.event.MenuItemEvent;
import com.dumptruckman.actionmenu2.api.event.MenuItemListener;

public class ViewEditListener implements MenuItemListener {
    
    private MenuHandle menuHandle;
    private Menu viewEditMenu;
    
    public ViewEditListener(MenuHandle menuHandle, Menu viewEditMenu) {
        this.menuHandle = menuHandle;
        this.viewEditMenu = viewEditMenu;
    }

    @Override
    public void onAction(MenuItemEvent menuItemEvent) {
        this.menuHandle.setMenu(this.viewEditMenu);
    }

    @Override
    public void onMenuItemChange(MenuItemEvent menuItemEvent) { }
}
