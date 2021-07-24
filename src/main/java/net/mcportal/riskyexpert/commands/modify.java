package net.mcportal.riskyexpert.commands;

import net.mcportal.riskyexpert.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class modify implements CommandExecutor {
    Main plugin;
    public modify(Main instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("whereami-set")) {
            if(sender.hasPermission("whereami.admin")){
                if(args.length == 1){
                    plugin.getConfig().set("servername", args[0]);
                    plugin.saveConfig();
                    plugin.reloadConfig();
                    sender.sendMessage(ChatColor.GREEN + "Server name has been set to " + ChatColor.WHITE + args[0] + ChatColor.GREEN +"!");
                } else {
                    sender.sendMessage(ChatColor.RED + "Invalid syntax. " + ChatColor.GOLD + "Hint: /whereami-set <servername>");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
            }
        }
        return false;
    }
}
