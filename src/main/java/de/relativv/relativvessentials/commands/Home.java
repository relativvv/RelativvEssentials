package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import de.relativv.relativvessentials.utils.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Home implements CommandExecutor {

    private Essentials plugin;
    public Home(Essentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(args.length == 1) {
                String name = args[0].toLowerCase();

                if(FileManager.homeCfg.isSet(p.getName() + "." + name + ".x")) {

                    double x = FileManager.homeCfg.getDouble(p.getName() + "." + name + ".x");
                    double y = FileManager.homeCfg.getDouble(p.getName() + "." + name + ".y");
                    double z = FileManager.homeCfg.getDouble(p.getName() + "." + name + ".z");

                    double yaw = FileManager.homeCfg.getDouble(p.getName() + "." + name + ".yaw");
                    double pitch = FileManager.homeCfg.getDouble(p.getName() + "." + name + ".pitch");

                    String worldname = FileManager.homeCfg.getString(p.getName() + "." + name + ".worldname");
                    Location loc = new Location(Bukkit.getWorld(worldname), x, y, z);
                    loc.setYaw((float) yaw);
                    loc.setPitch((float) pitch);

                    p.teleport(loc);

                    p.sendMessage(plugin.pr + "§7Du hast dich zum Home §a" + capitalize(name) + " §7teleportiert.");
                    p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);


                } else {
                    p.sendMessage(plugin.pr + "§7Dieses Home existiert nicht.");
                }

            } else {
                if(FileManager.homeCfg.contains(p.getName())) {
                    p.sendMessage("§8========= §8[ §e" + p.getName() + " §7- Homes §8] §8=========");
                    p.sendMessage(" ");
                    for (String name : FileManager.homeCfg.getConfigurationSection(p.getName()).getKeys(false)) {
                        p.sendMessage("§8- §e" + capitalize(name));
                    }
                    p.sendMessage(" ");
                    p.sendMessage("§8========= §9[ §e" + p.getName() + " §7- Homes 98] §8=========");
                } else {
                    p.sendMessage(plugin.pr + "§cDu hast keine Homes!");
                }
            }


        }
        return true;
    }






    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
