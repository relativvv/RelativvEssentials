package de.relativv.relativvessentials.listener;

import de.relativv.relativvessentials.main.Essentials;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPing implements Listener {

    private Essentials plugin;
    public ServerListPing(Essentials plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onServerListPing(ServerListPingEvent e) {
        e.setMotd("§0[§aLobby§0]");
    }

}
