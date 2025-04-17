package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import de.relativv.relativvessentials.utils.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Warp implements CommandExecutor, TabCompleter {

    private Essentials plugin;
    public Warp(Essentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;


                if(args.length == 1) {

                    String warpname = args[0].toLowerCase();
                    if(FileManager.cfg.isSet("warp." + warpname + ".x")) {

                        double x = FileManager.cfg.getDouble("warp." + warpname + ".x");
                        double y = FileManager.cfg.getDouble("warp." + warpname + ".y");
                        double z = FileManager.cfg.getDouble("warp." + warpname + ".z");
                        double yaw = FileManager.cfg.getDouble("warp." + warpname + ".yaw");
                        double pitch = FileManager.cfg.getDouble("warp." + warpname + ".pitch");
                        String worldname = FileManager.cfg.getString("warp." + warpname + ".worldname");
                        Location loc = new Location(Bukkit.getWorld(worldname), x, y, z);
                        loc.setYaw((float) yaw);
                        loc.setPitch((float) pitch);
                        p.teleport(loc);
                        p.sendMessage(plugin.pr + "§7Du hast dich zum Warp §a" + capitalize(warpname) + " §7teleportiert.");

                    } else {
                        p.sendMessage(plugin.pr + "§cDieser Warp existiert nicht.");
                    }

                } else if(args.length == 0) {

                    p.sendMessage("§7========= §8[ §aWarps §8] §7=========");
                    p.sendMessage(" ");
                    for(String name : FileManager.cfg.getConfigurationSection("warp").getKeys(false)) {
                        p.sendMessage("§8- §e" + name);
                    }
                    p.sendMessage(" ");
                    p.sendMessage("§7========= §8[ §aWarps §8] §7=========");

                } else {
                    p.sendMessage(plugin.pr + "§c/warp <Warpname>");
                }
        }
        return true;
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> tab = new ArrayList<>();

        for(String name : FileManager.cfg.getConfigurationSection("warp").getKeys(false)) {
            tab.add(capitalize(name));
        }

        return tab;
    }

    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
