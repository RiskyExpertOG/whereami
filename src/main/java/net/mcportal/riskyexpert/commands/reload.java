package net.mcportal.riskyexpert.commands;

import net.mcportal.riskyexpert.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reload implements CommandExecutor {
    Main plugin;
    public reload(Main instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("whereami-reload")) {
            if(sender.hasPermission("whereami.admin")){
                plugin.reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "Reload config command received!");
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
            }
        }
            return false;
    }

}
