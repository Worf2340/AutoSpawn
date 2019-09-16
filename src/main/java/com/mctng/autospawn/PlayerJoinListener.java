package com.mctng.autospawn;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    AutoSpawn plugin;

    public PlayerJoinListener(AutoSpawn plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        int x = plugin.getConfig().getInt("spawn.x");
        int y = plugin.getConfig().getInt("spawn.y");
        int z = plugin.getConfig().getInt("spawn.z");

        event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), x, y, z ));
    }
}
