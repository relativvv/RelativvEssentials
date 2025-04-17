package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Day implements CommandExecutor {

    private Essentials plugin;
    public Day(Essentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(p.hasPermission("system.day")) {

                p.getWorld().setTime(1000L);
                p.sendMessage(plugin.pr + "§aEs ist nun Tag!");

            } else {
                sender.sendMessage(Essentials.getInstance().noPerm);
            }

        }
        return true;
    }
}
