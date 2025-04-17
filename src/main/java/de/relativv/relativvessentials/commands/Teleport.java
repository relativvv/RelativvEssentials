package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {

    private Essentials plugin;
    public Teleport(Essentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("system.teleport")) {
                if (args.length == 1) {
                    String name = args[0];
                    if (Bukkit.getOfflinePlayer(name).isOnline()) {

                        Player target = Bukkit.getPlayer(name);
                        p.teleport(target);
                        p.sendMessage(plugin.pr + "§7Du hast dich zu §a" + target.getName() + " §7teleportiert!");

                    } else {
                        p.sendMessage(plugin.pr + "§cDieser Spieler ist nicht Online!");
                    }

                } else if(args.length == 2) {
                    String name = args[0];
                    if (Bukkit.getOfflinePlayer(name).isOnline()) {

                        Player target = Bukkit.getPlayer(name);
                        target.teleport(p);
                        p.sendMessage(plugin.pr + "§7Du hast §a" + target.getName() + " §7zu dir teleportiert!");
                        target.sendMessage(plugin.pr + "§7Du wurdest zu §a" + p.getName() + " §7teleportiert.");

                    } else {
                        p.sendMessage(plugin.pr + "§cDieser Spieler ist nicht Online!");
                    }


                } else if (args.length == 3) {
                    if(isInteger(args[0]) && isInteger(args[1]) && isInteger(args[2])) {

                        int x = Integer.parseInt(args[0]);
                        int y = Integer.parseInt(args[1]);
                        int z = Integer.parseInt(args[2]);

                        Location loc = new Location(p.getWorld(), x, y, z);
                        p.teleport(loc);
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                        p.sendMessage(plugin.pr + "§7Du hast dich zu folgenden Koordinaten teleporiert!");
                        p.sendMessage(plugin.pr + "§eX§8: §a" + x);
                        p.sendMessage(plugin.pr + "§eY§8: §a" + y);
                        p.sendMessage(plugin.pr + "§eZ§8: §a" + z);



                    } else {
                        p.sendMessage(plugin.pr + "§cDu musst Zahlen als Koordinaten angeben.");
                    }


                } else if(args.length == 4) {
                    String name = args[0];
                    if(Bukkit.getOfflinePlayer(name).isOnline()) {
                        if(isInteger(args[1]) && isInteger(args[2]) && isInteger(args[3])) {

                            Player target = Bukkit.getPlayer(name);

                            int x = Integer.parseInt(args[1]);
                            int y = Integer.parseInt(args[2]);
                            int z = Integer.parseInt(args[3]);

                            Location loc = new Location(target.getWorld(), x, y, z);
                            target.teleport(loc);
                            target.playSound(target.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);

                            p.sendMessage(plugin.pr + "§7Du hast §a" + target.getName() + " §7zu folgenden Koordinaten teleporiert!");
                            p.sendMessage(plugin.pr + "§eX§8: §a" + x);
                            p.sendMessage(plugin.pr + "§eY§8: §a" + y);
                            p.sendMessage(plugin.pr + "§eZ§8: §a" + z);

                            target.sendMessage(plugin.pr + "§7Du wurdest zu folgenden Koordinaten teleporiert!");
                            target.sendMessage(plugin.pr + "§eX§8: §a" + x);
                            target.sendMessage(plugin.pr + "§eY§8: §a" + y);
                            target.sendMessage(plugin.pr + "§eZ§8: §a" + z);



                        } else {
                            p.sendMessage(plugin.pr + "§cDu musst Zahlen als Koordinaten angeben.");
                        }
                    } else {
                        p.sendMessage(plugin.pr + "§cDieser Spieler ist nicht Online!");
                    }
                } else {
                    p.sendMessage(plugin.pr + "§c/tp <Spieler>");
                    p.sendMessage(plugin.pr + "§c/tp <Spieler> <Spieler>");
                    p.sendMessage(plugin.pr + "§c/tp <Spieler> <X Y Z>");
                    p.sendMessage(plugin.pr + "§c/tp <X Y Z>");

                }

            } else {
                p.sendMessage(plugin.noPerm);
            }
        }
        return true;
    }

    private boolean isInteger(String s) {
        try {
            int t = Integer.parseInt(s);
            return true;
        } catch(NumberFormatException ex) {
            return false;
        }
    }

}
