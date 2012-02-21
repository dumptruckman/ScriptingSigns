package com.dumptruckman.scriptingsigns.menu;

import com.dumptruckman.actionmenu2.api.Menu;
import com.dumptruckman.actionmenu2.api.event.MenuItemEvent;
import com.dumptruckman.actionmenu2.api.event.MenuItemListener;

public class ViewEditListener implements MenuItemListener {
    
    private Menu menuHandle;
    private Menu viewEditMenu;
    
    public ViewEditListener(Menu menuHandle, Menu viewEditMenu) {
        this.menuHandle = menuHandle;
        this.viewEditMenu = viewEditMenu;
    }

    @Override
    public void onAction(MenuItemEvent menuItemEvent) {
        this.menuHandle.setModel(this.viewEditMenu.getModel());
    }

    @Override
    public void onMenuItemChange(MenuItemEvent menuItemEvent) { }
}
