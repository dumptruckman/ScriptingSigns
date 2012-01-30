package com.dumptruckman.scriptingsigns.locale;

import com.dumptruckman.scriptingsigns.util.Font;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * Implementation of a Messager and MessageProvider using SimpleMessageProvider to implement the latter.
 */
public class SimpleMessager extends SimpleMessageProvider implements Messager, MessageProvider {

    public SimpleMessager(JavaPlugin plugin) {
        super(plugin);
    }

    private void send(Message message, String prefix, CommandSender sender, Object... args) {
        List<String> messages = this.getMessages(message, args);
        if (!messages.isEmpty()) {
            messages.set(0, prefix + " " + messages.get(0));
            sendMessages(sender, messages);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void bad(Message message, CommandSender sender, Object... args) {
        send(message, ChatColor.RED.toString() + this.getMessage(Message.GENERIC_ERROR), sender, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void normal(Message message, CommandSender sender, Object... args) {
        send(message, "", sender, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void good(Message message, CommandSender sender, Object... args) {
        send(message, ChatColor.GREEN.toString() + this.getMessage(Message.GENERIC_SUCCESS), sender, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Message message, CommandSender sender, Object... args) {
        send(message, ChatColor.YELLOW.toString() + this.getMessage(Message.GENERIC_INFO), sender, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void help(Message message, CommandSender sender, Object... args) {
        send(message, ChatColor.GRAY.toString() + this.getMessage(Message.GENERIC_HELP), sender, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendMessage(CommandSender player, String message) {
        List<String> messages = Font.splitString(message);
        sendMessages(player, messages);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendMessages(CommandSender player, List<String> messages) {
        for (String s : messages) {
            player.sendMessage(s);
        }
    }
}

