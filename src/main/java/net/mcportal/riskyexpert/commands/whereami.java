package net.mcportal.riskyexpert.commands;

import net.mcportal.riskyexpert.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class whereami implements CommandExecutor {
    Main plugin;
    public whereami(Main instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String servernames = plugin.getConfig().getString("servername");
        if (cmd.getName().equalsIgnoreCase("whereami")) {
            if (!(sender instanceof Player)) {
                if(plugin.getConfig().getString("servername").contains("server_name_goes_here")){
                    sender.sendMessage(ChatColor.RED + "You haven't set a server name yet! Navigate to plugins/whereami/config.yml and change the default name.");
                } else {
                    sender.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "This server is " + ChatColor.GOLD + servernames + ChatColor.AQUA + ".");
                }
            } else {
                if(plugin.getConfig().getString("servername").contains("server_name_goes_here")){
                    sender.sendMessage(ChatColor.RED + "Could not parse server name! Please try again later.");
                }else{
                    sender.sendMessage(ChatColor.AQUA + "" +ChatColor.ITALIC + "You are currently connected on " + ChatColor.GOLD + servernames + ChatColor.AQUA + ".");
                }
            }
        return false;
        }
        return false;
    }
}
