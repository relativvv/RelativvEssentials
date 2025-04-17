package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import de.relativv.relativvessentials.utils.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class DelWarp implements CommandExecutor, TabCompleter {


    private Essentials plugin;
    public DelWarp(Essentials plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("system.delwarp")) {
                if (args.length == 1) {

                    String warpName = args[0].toLowerCase();
                    if(FileManager.cfg.isSet("warp." + warpName + ".x")) {

                        FileManager.cfg.set("warp." + warpName, null);
                        FileManager.saveFile();

                        p.sendMessage(plugin.pr + "§7Du hast den Warp §a" + capitalize(warpName) + " §7gelöscht.");

                    } else {
                        p.sendMessage(plugin.pr + "§cDieser Warp existiert nicht.");
                    }

                } else {
                    p.sendMessage(plugin.pr + "§c/delwarp <Name>");
                }
            } else {
                p.sendMessage(plugin.noPerm);
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
