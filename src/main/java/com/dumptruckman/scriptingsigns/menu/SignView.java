package com.dumptruckman.scriptingsigns.menu;

import com.dumptruckman.actionmenu2.api.AbstractSignView;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SignView extends AbstractSignView {
    
    public SignView(Plugin plugin, Sign sign) {
        super(plugin, sign);
    }
    
    @Override
    public void show(Player player) {
        if (this.getMenu() == null) {
            return;
        }
        System.out.println("showing menu");
        Sign sign = this.getSign();
        for(int i = 0; i < this.getMenu().getContents().size() && i < 4; i++) {
            String text = this.getMenu().getContents().get(i).getText();
            System.out.println("showing item: " + text);
            if (this.getMenu().getContents().get(i).isSelectable()) {
                if (this.getMenu().getContents().getSelectedIndex() == i) {
                    text = "> " + text;
                } else {
                    text = "  " + text;
                }
            }
            StringBuilder builder = new StringBuilder();
            builder.append(text);
            for (int j = text.length(); j <= 15; j++) {
                builder.append(" ");
            }
            text = builder.toString();
            sign.setLine(i, text);
        }
        sign.update(true);
    }
}
