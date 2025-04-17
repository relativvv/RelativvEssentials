package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import de.relativv.relativvessentials.nick.NickAPI;
import de.relativv.relativvessentials.nick.NickUtils;
import de.relativv.relativvessentials.utils.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Nick implements CommandExecutor {

    private Essentials plugin;
    public Nick(Essentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("system.owner")
                    || p.hasPermission("system.admin")
                    || p.hasPermission("system.dev")
                    || p.hasPermission("system.builder")
                    || p.isOp()
                    || p.hasPermission("system.yt")
                    || p.hasPermission("system.premium")
                    || p.hasPermission("system.mod")
                    || p.hasPermission("system.sup")) {

                if(NickUtils.playerNicked(p)) {

                    NickUtils.unnickPlayer(p);
                    p.sendMessage(NickAPI.prefix + "§4Dein Nickname wurde entfernt!");

                    for(Player all : Bukkit.getOnlinePlayers()) {
                        ScoreboardManager.updateScoreboard(all);
                    }



                } else {
                    p.sendMessage(NickAPI.prefix + "§cDu bist nicht genickt!");
                }

            } else {
                p.sendMessage(NickAPI.prefix + "§cDu hast keine Berechtigung dazu!");
            }
        }
        return true;
    }
}
