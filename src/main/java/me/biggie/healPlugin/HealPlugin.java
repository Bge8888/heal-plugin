package me.biggie.healPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class HealPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommand("heal", new HealCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
