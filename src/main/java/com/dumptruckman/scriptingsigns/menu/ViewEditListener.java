package com.dumptruckman.scriptingsigns.menu;

import com.dumptruckman.actionmenu2.api.Menu;
import com.dumptruckman.actionmenu2.api.MenuModel;
import com.dumptruckman.actionmenu2.api.event.MenuItemEvent;
import com.dumptruckman.actionmenu2.api.event.MenuItemListener;
import com.dumptruckman.scriptingsigns.sign.ScriptSign;

public class ViewEditListener implements MenuItemListener {
    
    private Menu scriptSign;
    private MenuModel viewEditMenu;
    
    public ViewEditListener(ScriptSign scriptSign, MenuModel viewEditMenu) {
        this.scriptSign = scriptSign;
        this.viewEditMenu = viewEditMenu;
    }

    @Override
    public void onAction(MenuItemEvent menuItemEvent) {
        this.scriptSign.setModel(this.viewEditMenu);
    }

    @Override
    public void onMenuItemChange(MenuItemEvent menuItemEvent) { }
}
