package com.dumptruckman.scriptingsigns.sign;

import com.dumptruckman.actionmenu2.api.Menu;
import com.dumptruckman.actionmenu2.api.MenuItem;
import com.dumptruckman.actionmenu2.api.MenuModel;
import com.dumptruckman.actionmenu2.api.MenuViews;
import com.dumptruckman.actionmenu2.api.event.MenuEvent;
import com.dumptruckman.actionmenu2.api.event.MenuListener;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

import java.util.Set;

public class DefaultScriptSign implements ScriptSign {

    private Block block;
    private Sign sign;
    private Player owner;
    private Menu menu;
    
    protected DefaultScriptSign(Sign sign, Player owner, Menu menu) {
        this.block = sign.getBlock();
        this.sign = sign;
        this.owner = owner;
        this.menu = menu;
    }

    @Override
    public Block getBlock() {
        return block;
    }

    @Override
    public Sign getSign() {
        return sign;
    }

    @Override
    public MenuModel getModel() {
        return menu.getModel();
    }

    @Override
    public void setModel(MenuModel menuItems) {
        menu.setModel(menuItems);
    }

    @Override
    public MenuItem getSelected() {
        return menu.getSelected();
    }

    @Override
    public void cycleSelection() {
        menu.cycleSelection();
    }

    @Override
    public void cycleSelection(boolean b) {
        menu.cycleSelection(b);
    }

    @Override
    public MenuViews getViews() {
        return menu.getViews();
    }

    @Override
    public void setUser(Player player) {
        menu.setUser(player);
    }

    @Override
    public Player getUser() {
        return menu.getUser();
    }

    @Override
    public void updateViews() {
        menu.updateViews();
    }

    @Override
    public Player getOwner() {
        return this.owner;
    }

    @Override
    public Set<MenuListener> getMenuListeners() {
        return this.menu.getMenuListeners();
    }

    @Override
    public void onContentsAdd(MenuEvent menuEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onContentsRemove(MenuEvent menuEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onContentsChange(MenuEvent menuEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onSelectionChange(MenuEvent menuEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
    
    public String toString() {
        return this.menu.toString();
    }
}
