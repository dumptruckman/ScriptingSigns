package com.dumptruckman.scriptingsigns.menu;

import com.dumptruckman.actionmenu2.api.AbstractSignView;
import com.dumptruckman.actionmenu2.api.Menu;
import com.dumptruckman.actionmenu2.api.MenuContents;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SignView extends AbstractSignView {
    
    public SignView(Sign sign) {
        super(sign);
    }
    
    @Override
    public void showMenu(Menu menu, Player player) {
        if (menu == null) {
            return;
        }
        Sign sign = this.getSign();
        MenuContents contents = menu.getContents();
        for (int i = 0; i < 4; i++) {
            String text = "";
            if (i < contents.size()) {
                text = contents.get(i).getText();
                if (contents.get(i).isSelectable()) {
                    if (contents.getSelectedIndex() == i) {
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
}
