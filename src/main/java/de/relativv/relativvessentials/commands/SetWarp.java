package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import de.relativv.relativvessentials.utils.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarp implements CommandExecutor {

    private Essentials plugin;
    public SetWarp(Essentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 1) {
                if (p.hasPermission("system.setwarp")) {

                    String warpname = args[0].toLowerCase();

                        double x = p.getLocation().getX();
                        double y = p.getLocation().getY();
                        double z = p.getLocation().getZ();

                        double yaw = p.getLocation().getYaw();
                        double pitch = p.getLocation().getPitch();

                        String worldname = p.getWorld().getName();

                        FileManager.cfg.set("warp." + warpname + ".x", x);
                        FileManager.cfg.set("warp." + warpname + ".y", y);
                        FileManager.cfg.set("warp." + warpname + ".z", z);
                        FileManager.cfg.set("warp." + warpname + ".yaw", yaw);
                        FileManager.cfg.set("warp." + warpname + ".pitch", pitch);

                        FileManager.cfg.set("warp." + warpname + ".worldname", worldname);

                        FileManager.saveFile();

                        p.sendMessage(plugin.pr + "§7Du hast den Warp §a" + capitalize(warpname) + " §7gesetzt!");

                } else {
                    p.sendMessage(plugin.noPerm);
                }
            } else {
                p.sendMessage(plugin.pr + "/setwarp <Name>");
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
