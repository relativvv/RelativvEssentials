package de.relativv.relativvessentials.listener;

import de.relativv.relativvessentials.nick.NickUtils;
import de.relativv.relativvessentials.utils.GlobalUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.inventivetalent.nicknamer.NickNamer;

public class AsyncPlayerChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if(NickUtils.playerNicked(p)) {
            e.setFormat("§6" + NickNamer.getNickManager().getNick(p.getUniqueId()) + "§8: §7" + e.getMessage());
        } else {
            e.setFormat(GlobalUtils.getRankPrefix(p) + p.getName() + "§8: §7" + e.getMessage());
        }
    }
}
