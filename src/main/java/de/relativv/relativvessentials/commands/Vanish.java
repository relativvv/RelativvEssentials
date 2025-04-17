package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Vanish implements CommandExecutor {

    private Essentials plugin;
    public Vanish(Essentials plugin) {
        this.plugin = plugin;
    }


    private ArrayList<Player> isVanished = new ArrayList<>();


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("system.vanish")) {

                if(args.length == 0) {
                    if(!isVanished.contains(p)) {
                        isVanished.add(p);
                        p.sendMessage(plugin.pr + "§7Du hast den Vanish-Modus §aaktiviert§7!");
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            if (!all.hasPermission("system.vanishBypass")) {
                                all.hidePlayer(p);
                            }
                        }
                        Bukkit.broadcastMessage("§c<§4<§c< §r" + p.getDisplayName());

                    } else {
                        isVanished.remove(p);
                        p.sendMessage(plugin.pr + "§7Du hast den Vanish-Modus §cdeaktiviert§7!");
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.showPlayer(p);
                        }
                        Bukkit.broadcastMessage("§a>§2>§a> §r" + p.getDisplayName());
                    }



                } else if(args.length == 1) {
                    String name = args[0];
                    if(Bukkit.getOfflinePlayer(name).isOnline()) {
                        Player target = Bukkit.getPlayer(name);

                        if (!isVanished.contains(target)) {
                            isVanished.add(target);
                            p.sendMessage(plugin.pr + "§7Du hast den Vanish-Modus von §r" + target.getDisplayName() + " §aaktiviert§7!");
                            target.sendMessage(plugin.pr + "§7Dein Vanish-Modus wurde §aaktiviert§7!");
                            target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                if (!all.hasPermission("system.vanishBypass")) {
                                    all.hidePlayer(target);
                                }
                            }
                            Bukkit.broadcastMessage("§c<§4<§c< §r" + p.getDisplayName());

                        } else {
                            isVanished.remove(target);
                            p.sendMessage(plugin.pr + "§7Du hast den Vanish-Modus von §r" + target.getDisplayName() + " §cdeaktiviert§7!");
                            target.sendMessage(plugin.pr + "§7Dein Vanish-Modus wurde §cdeaktiviert§7!");
                            target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.showPlayer(target);
                            }
                            Bukkit.broadcastMessage("§a>§2>§a> §r" + p.getDisplayName());
                        }

                    } else {
                        p.sendMessage(plugin.pr + "§cDieser Spieler ist nicht Online!");
                    }

                } else {
                    p.sendMessage(plugin.pr + "§c/vanish <Spieler>");
                }

            } else {
                p.sendMessage(plugin.noPerm);
            }
        }
        return true;
    }
}
