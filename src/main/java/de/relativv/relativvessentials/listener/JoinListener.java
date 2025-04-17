package de.relativv.relativvessentials.listener;

import de.relativv.relativvessentials.main.Essentials;
import de.relativv.relativvessentials.nick.NickAPI;
import de.relativv.relativvessentials.nick.NickUtils;
import de.relativv.relativvessentials.utils.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.inventivetalent.nicknamer.NickNamer;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if (Essentials.getInstance().nickAPI.isNicked(p)) {
            NickUtils.nickPlayer(p);
            new BukkitRunnable() {
                @Override
                public void run() {
                    NickNamer.getNickManager().updatePlayer(p, true, true, true);
                    NickNamer.getNickManager().updatePlayer(p.getUniqueId(), true, true, true);
                }
            }.runTaskLater(Essentials.getInstance(), 5L);
            for(Player all : Bukkit.getOnlinePlayers()) {
                ScoreboardManager.updateScoreboard(all);
            }
        }


        ScoreboardManager.setScoreboard(p);



        if(NickUtils.playerNicked(p)) {
            e.setJoinMessage("§a>§2>§a> §6" + NickNamer.getNickManager().getNick(p.getUniqueId()));
        } else {
            e.setJoinMessage("§a>§2>§a> §r" + p.getDisplayName());
        }


        if (Essentials.getInstance().nickAPI.isNicked(p)) {
            p.sendMessage(NickAPI.prefix + "§4Dein neuer Nickname§8: §6" + NickNamer.getNickManager().getNick(p.getUniqueId()));
        } else {
            p.sendMessage(NickAPI.prefix + "§cDu bist aktuell nicht genickt!");
        }


        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);

        for (Player all : Bukkit.getOnlinePlayers()) {
            ScoreboardManager.updateScoreboard(all);
            all.showPlayer(p);
        }

    }
}
