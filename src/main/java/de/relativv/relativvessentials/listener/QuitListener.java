package de.relativv.relativvessentials.listener;

import de.relativv.relativvessentials.nick.NickUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.inventivetalent.nicknamer.NickNamer;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();



        if(NickUtils.playerNicked(p)) {
            e.setQuitMessage("§c<§4<§c< §6" + NickNamer.getNickManager().getNick(p.getUniqueId()));
            NickUtils.unnickPlayer(p);
        } else {
            e.setQuitMessage("§c<§4<§c< §r" + p.getDisplayName());
        }
    }
}
