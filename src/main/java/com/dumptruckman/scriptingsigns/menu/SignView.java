package com.dumptruckman.scriptingsigns.menu;

import com.dumptruckman.actionmenu2.api.AbstractSignView;
import com.dumptruckman.actionmenu2.api.Menu;
import com.dumptruckman.actionmenu2.api.MenuModel;
import com.dumptruckman.actionmenu2.api.event.MenuEvent;
import com.dumptruckman.actionmenu2.api.event.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SignView extends AbstractSignView implements MenuListener {

    public static final long UPDATE_TICKS = 10;
    public static final int SIGN_LINES = 4;
    public static final int LINE_LENGTH = 14;

    private int leadIndex = 0;
    private int selectedTextIndex = 0;
    private Plugin plugin;

    public SignView(Plugin plugin, Sign sign) {
        super(sign);
        this.plugin = plugin;
    }

    @Override
    public void showMenu(Menu menu, Player player) {
        if (menu == null) {
            return;
        }
        Sign sign = getSign();
        MenuModel menuModel = menu.getModel();
        for (int i = 0, menuIndex = this.leadIndex; i < SIGN_LINES; i++, menuIndex++) {
            String text = "";
            if (menuIndex < menuModel.size()) {
                String menuText = menuModel.get(menuIndex).getText();
                if (this.selectedTextIndex >= menuText.length()) {
                    this.selectedTextIndex = 0;
                }
                text = menuText.substring(selectedTextIndex);
                if (menuModel.get(menuIndex).isSelectable()) {
                    if (menuModel.getSelectedIndex() == menuIndex) {
                        text = ChatColor.RED + text;
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            builder.append(text);
            for (int j = text.length(); j <= 16; j++) {
                builder.append(" ");
            }
            text = builder.toString();
            sign.setLine(i, text);
        }
        sign.update(true);
    }

    @Override
    public void onSelectionChange(MenuEvent event) {
        this.selectedTextIndex = 0;
        if (event.getIndex1() > event.getIndex0()) {
            int menuSize = event.getModel().size();
            if (event.getIndex1() >= menuSize - 1) {
                this.leadIndex = menuSize - SIGN_LINES;
            } else {
                this.leadIndex = event.getIndex1() - 2;
            }
        } else if (event.getIndex1() < event.getIndex0()) {
            if (event.getIndex1() <= 0) {
                this.leadIndex = 0;
            } else {
                this.leadIndex = event.getIndex1() - 1;
            }
        }
        if (this.leadIndex < 0) {
            this.leadIndex = 0;
        }
    }

    @Override
    public void onContentsAdd(MenuEvent menuEvent) { }

    @Override
    public void onContentsRemove(MenuEvent menuEvent) { }

    @Override
    public void onContentsChange(MenuEvent menuEvent) { }

    private class TickerTask implements Runnable {
        
        int taskCount = 0;
        int taskId = -1;

        public void start() {
            if (taskId == -1) {
                schedule();
            }
        }

        public void stop() {
            Bukkit.getScheduler().cancelTask(taskId);
            taskId = -1;
            taskCount = 0;
        }

        private void schedule() {
            this.taskId = Bukkit.getScheduler()
                    .scheduleSyncDelayedTask(SignView.this.plugin, this, UPDATE_TICKS);
            taskCount++;
        }

        private void updateSelection() {
            
        }

        @Override
        public void run() {
            updateSelection();
            schedule();
        }
    }
}
