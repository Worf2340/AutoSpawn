package com.mctng.autospawn;

import org.bukkit.plugin.java.JavaPlugin;

public final class AutoSpawn extends JavaPlugin {


    @Override
    public void onEnable() {
        this.getCommand("setspawn").setExecutor(new SetspawnCommand(this));
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
