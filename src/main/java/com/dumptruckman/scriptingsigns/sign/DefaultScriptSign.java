package com.dumptruckman.scriptingsigns.sign;

import com.dumptruckman.actionmenu2.api.Menu;
import com.dumptruckman.actionmenu2.api.MenuContents;
import com.dumptruckman.actionmenu2.api.MenuHandle;
import com.dumptruckman.actionmenu2.api.MenuItem;
import com.dumptruckman.actionmenu2.api.MenuView;
import com.dumptruckman.actionmenu2.api.event.MenuListener;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public class DefaultScriptSign implements ScriptSign {

    private Block block;
    private Sign sign;
    private Player owner;
    private MenuHandle menuHandle;
    
    protected DefaultScriptSign(Sign sign, Player owner, MenuHandle menuHandle) {
        this.block = sign.getBlock();
        this.sign = sign;
        this.owner = owner;
        this.menuHandle = menuHandle;
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
    public Player getOwner() {
        return owner;
    }

    @Override
    public final MenuHandle getMenuHandle() {
        return menuHandle;
    }

    @Override
    public void touch(Player player) {
        this.getMenuHandle().touch(player);
    }

    @Override
    public Player getPlayer() {
        return this.getMenuHandle().getPlayer();
    }

    @Override
    public Plugin getPlugin() {
        return this.getMenuHandle().getPlugin();
    }

    @Override
    public void show(Player player) {
        this.getMenuHandle().show(player);
    }

    @Override
    public void setMenu(Menu menu) {
        this.getMenuHandle().setMenu(menu);
    }

    @Override
    public Menu getMenu() {
        return this.getMenuHandle().getMenu();
    }

    @Override
    public void updateViews(Player player) {
        this.getMenuHandle().updateViews(player);
    }

    @Override
    public void cycleMenu() {
        getMenuHandle().cycleMenu();
    }

    @Override
    public void cycleMenu(boolean reverse) {
        getMenuHandle().cycleMenu(reverse);
    }

    @Override
    public Set<MenuView> getViews() {
        return getMenuHandle().getViews();
    }

    @Override
    public boolean addView(MenuView menuView) {
        return getMenuHandle().addView(menuView);
    }

    @Override
    public boolean removeView(MenuView menuView) {
        return getMenuHandle().removeView(menuView);
    }

    @Override
    public MenuContents getContents() {
        return getMenuHandle().getContents();
    }

    @Override
    public MenuItem getSelected() {
        return getMenuHandle().getSelected();
    }

    @Override
    public Set<MenuListener> getMenuListeners() {
        return getMenuHandle().getMenuListeners();
    }

    @Override
    public void run(MenuItem menuItem) {
        getMenuHandle().run(menuItem);
    }

    @Override
    public void runSelected() {
        getMenuHandle().runSelected();
    }
}
