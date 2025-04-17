package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import de.relativv.relativvessentials.utils.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHome implements CommandExecutor {

    private Essentials plugin;
    public SetHome(Essentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(args.length == 1) {
                if(args[0].length() <= 16) {
                    String name = args[0].toLowerCase();

                    double x = p.getLocation().getX();
                    double y = p.getLocation().getY();
                    double z = p.getLocation().getZ();

                    double yaw = p.getLocation().getYaw();
                    double pitch = p.getLocation().getPitch();

                    String worldname = p.getWorld().getName();


                    FileManager.homeCfg.set(p.getName() + "." + name + ".x", x);
                    FileManager.homeCfg.set(p.getName() + "." + name + ".y", y);
                    FileManager.homeCfg.set(p.getName() + "." + name + ".z", z);

                    FileManager.homeCfg.set(p.getName() + "." + name + ".yaw", yaw);
                    FileManager.homeCfg.set(p.getName() + "." + name + ".pitch", pitch);

                    FileManager.homeCfg.set(p.getName() + "." + name + ".worldname", worldname);
                    FileManager.saveHomes();

                    p.sendMessage(plugin.pr + "§7Du hast ein neues Zuhause gesetzt§8: §a" + capitalize(name));



                } else {
                    p.sendMessage(plugin.pr + "§cDieser Name ist zu lang!");
                }

            } else {
                p.sendMessage(plugin.pr + "§c/sethome <Name>");
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
