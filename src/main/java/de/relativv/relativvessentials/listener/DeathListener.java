package de.relativv.relativvessentials.listener;

import de.relativv.relativvessentials.main.Essentials;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DeathListener implements Listener {

    private Essentials plugin;
    public DeathListener(Essentials plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onEntityDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        e.setDeathMessage(plugin.pr + "§7Der Spieler §a" + p.getName() + " §7ist gestorben!");
        new BukkitRunnable() {
            @Override
            public void run() {
                p.spigot().respawn();
            }
        }.runTaskLater(plugin, 10);
    }

}
