package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class TPA implements CommandExecutor {

    private Essentials plugin;
    public TPA(Essentials plugin) {
        this.plugin = plugin;
    }

    public static HashMap<Player, Player> tpa = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length == 1) {

                String name = args[0];
                if(Bukkit.getOfflinePlayer(name).isOnline()) {
                    Player target = Bukkit.getPlayer(name);

                    tpa.remove(target);
                    tpa.put(target, p);

                    p.sendMessage(plugin.pr + "§7Du hast §r" + target.getDisplayName() + " §7eine Teleportanfrage gesendet!");

                    target.sendMessage(" ");
                    target.sendMessage(plugin.pr + "§7Du hast eine Teleportanfrage von §r" + target.getDisplayName() + " §7erhalten.");
                    target.sendMessage(plugin.pr + "§a/tpaccept §7um die Anfrage zu akzeptieren.");
                    target.sendMessage(plugin.pr + "§c/tpdeny §7um ab die Anfrage abzulehnen.");

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if(target.isOnline()) {
                                tpa.remove(target);
                            }
                        }
                    }.runTaskLater(plugin, 20*30);



                } else {
                    p.sendMessage(plugin.pr + "§cDieser Spieler ist nicht Online!");
                }

            } else {
                p.sendMessage(plugin.pr + "§c/tpa <Spieler>");
            }

        }
        return true;
    }
}
