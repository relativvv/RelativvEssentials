package de.relativv.relativvessentials.listener;

import de.relativv.relativvessentials.main.Essentials;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CreatureSpawn implements Listener {

    private Essentials plugin;
    public CreatureSpawn(Essentials plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent e) {
        if(e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.BUILD_WITHER) {
            e.setCancelled(true);
        }
    }
}
