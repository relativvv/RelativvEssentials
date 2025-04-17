package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tpdeny implements CommandExecutor {

    private Essentials plugin;
    public Tpdeny(Essentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(TPA.tpa.containsKey(p)) {
                Player toTp = TPA.tpa.get(p);
                toTp.sendMessage(plugin.pr + p.getDisplayName() + " §7hat deine Teleportanfrage 7abgelehnt.");
                p.sendMessage(plugin.pr + "§7Du hast die Teleportanfrage von §r" + toTp.getDisplayName() + " §7abgelehnt.");

                TPA.tpa.remove(p);
            } else {
                p.sendMessage(plugin.pr + "§cDu hast keine Teleportanfrage!");
            }
        }
        return true;
    }

}
