package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

	private Essentials plugin;
	public Gamemode(Essentials plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("system.gamemode")) {
			if (args.length == 2) {
				String name = args[1];
				Player target = Bukkit.getPlayer(name);

				if (target != null) {

					if (sender instanceof Player) {
						((Player) sender).playSound(((Player) sender).getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
					}
					sender.sendMessage(plugin.pr + "§7Spielmodus des Spielers §a" + target.getName() + " §7geändert zu§8: §a" + args[0].toString().toUpperCase());


					switch (args[0]) {
						case "0":
							changeGamemode(target, GameMode.SURVIVAL);
							break;
						case "survival":
							changeGamemode(target, GameMode.SURVIVAL);
							break;
						case "s":
							changeGamemode(target, GameMode.SURVIVAL);
							break;

						case "1":
							changeGamemode(target, GameMode.CREATIVE);
							break;
						case "creative":
							changeGamemode(target, GameMode.CREATIVE);
							break;
						case "c":
							changeGamemode(target, GameMode.CREATIVE);
							break;

						case "2":
							changeGamemode(target, GameMode.ADVENTURE);
							break;
						case "adventure":
							changeGamemode(target, GameMode.ADVENTURE);
							break;
						case "a":
							changeGamemode(target, GameMode.ADVENTURE);
							break;

						case "3":
							changeGamemode(target, GameMode.SPECTATOR);
							break;
						case "spectator":
							changeGamemode(target, GameMode.SPECTATOR);
							break;
						case "sp":
							changeGamemode(target, GameMode.SPECTATOR);
							break;

						default:
							sender.sendMessage(plugin.pr + "§cSyntax§8: §a/gamemode <0 | 1 | 2 | 3> §a§o<Player>");
							break;
					}

				} else {
					sender.sendMessage(plugin.pr + "§cDieser Spieler ist nicht online!");
				}


			} else if (args.length == 1) {
				if (sender instanceof Player) {
					Player p = (Player) sender;

					switch (args[0]) {
						case "0":
							changeGamemode(p, GameMode.SURVIVAL);
							break;
						case "survival":
							changeGamemode(p, GameMode.SURVIVAL);
							break;
						case "s":
							changeGamemode(p, GameMode.SURVIVAL);
							break;

						case "1":
							changeGamemode(p, GameMode.CREATIVE);
							break;
						case "creative":
							changeGamemode(p, GameMode.CREATIVE);
							break;
						case "c":
							changeGamemode(p, GameMode.CREATIVE);
							break;

						case "2":
							changeGamemode(p, GameMode.ADVENTURE);
							break;
						case "adventure":
							changeGamemode(p, GameMode.ADVENTURE);
							break;
						case "a":
							changeGamemode(p, GameMode.ADVENTURE);
							break;

						case "3":
							changeGamemode(p, GameMode.SPECTATOR);
							break;
						case "spectator":
							changeGamemode(p, GameMode.SPECTATOR);
							break;
						case "sp":
							changeGamemode(p, GameMode.SPECTATOR);
							break;

						default:
							sender.sendMessage(plugin.pr + "§cSyntax§8: §a/gamemode <0 | 1 | 2 | 3> §a§o<Spieler>");
							break;

					}

				}

			} else {
				sender.sendMessage(plugin.pr + "§cSyntax§8: §a/gamemode <0 | 1 | 2 | 3> §a§o<Spieler>");
			}
		} else {
			sender.sendMessage(Essentials.getInstance().noPerm);
		}
		return true;
	}





	private void changeGamemode(Player p, GameMode mode) {
		p.setGameMode(mode);
		p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
		p.sendMessage(plugin.pr + "§7Dein neuer Spielmodus§8: §a" + mode.toString().toUpperCase());
	}
}
