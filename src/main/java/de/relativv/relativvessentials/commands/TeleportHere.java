package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportHere implements CommandExecutor {

    private Essentials plugin;
    public TeleportHere(Essentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("system.teleport")) {

                if(args.length == 1) {
                    String name = args[0];

                    if(Bukkit.getOfflinePlayer(name).isOnline()) {

                        Player target = Bukkit.getPlayer(name);

                        target.teleport(p);
                        p.sendMessage(plugin.pr + "§7Du hast §a" + target.getName() + " §7zu dir teleportiert.");
                        target.sendMessage(plugin.pr + "§7Du wurdest zu §a" + target.getName() + " §7teleportiert.");


                    } else {
                        p.sendMessage(plugin.pr + "§cDieser Spieler ist nicht Online!");
                    }

                } else {
                    p.sendMessage(plugin.pr + "§c/tphere <Spieler>");
                }

            } else {
                p.sendMessage(plugin.noPerm);
            }
        }
        return true;
    }
}
