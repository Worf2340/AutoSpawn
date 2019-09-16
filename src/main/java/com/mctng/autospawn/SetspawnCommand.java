package com.mctng.autospawn;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetspawnCommand implements CommandExecutor {

    AutoSpawn plugin;

    public SetspawnCommand (AutoSpawn plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        int x;
        int y;
        int z;

        if (args.length == 0) {
            if (sender instanceof Player){
                Location location = ((Player) sender).getLocation();
                x = location.getBlockX();
                y = location.getBlockY();
                z = location.getBlockZ();
            }
            else {
                sender.sendMessage(ChatColor.RED + "This command must be sent by a player to be used with no arguments.");
                return true;
            }
        }
        else if (args.length == 3) {
            try {
                x = Integer.parseInt(args[0]);
                y = Integer.parseInt(args[1]);
                z = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException e) {
                sender.sendMessage(ChatColor.RED + "Invalid coordinates!");
                return false;
            }
        }
        else {
            return false;
        }

        sender.sendMessage(ChatColor.GOLD + "Spawn set to " + ChatColor.DARK_GREEN + x + ChatColor.GOLD + ", " +
                ChatColor.DARK_GREEN + y + ChatColor.GOLD + ", " + ChatColor.DARK_GREEN + z + ChatColor.GOLD + ".");

        plugin.getConfig().set("spawn.x", x);
        plugin.getConfig().set("spawn.y", y);
        plugin.getConfig().set("spawn.z", z);

        return true;
    }
}
