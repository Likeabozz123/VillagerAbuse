package xyz.gamars.villagerabuse;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.gamars.villagerabuse.listeners.EntityDamageListener;

public final class VillagerAbuse extends JavaPlugin {

    public void registerEvent(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        registerEvent(new EntityDamageListener());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
