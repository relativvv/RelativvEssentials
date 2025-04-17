package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import de.relativv.relativvessentials.utils.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelHome implements CommandExecutor {

    private Essentials plugin;
    public DelHome(Essentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(args.length == 1) {
                String name = args[0].toLowerCase();

                if(FileManager.homeCfg.isSet(p.getName() + "." + name + ".x")) {

                    FileManager.homeCfg.set(p.getName() + "." + name, null);
                    FileManager.saveHomes();

                    p.sendMessage(plugin.pr + "§7Du hast das Home §a" + capitalize(name) + " §7gelöscht!");

                } else {
                    p.sendMessage(plugin.pr + "§7Dieses Home existiert nicht.");
                }

            } else {
                p.sendMessage(plugin.pr + "§c/delhome <Name>");
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
