package de.relativv.relativvessentials.commands;

import de.relativv.relativvessentials.main.Essentials;
import de.relativv.relativvessentials.utils.GlobalUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("system.fly")) {
			
			if(args.length == 0) {
				
				if(p.getAllowFlight() == true) {
					
					p.setAllowFlight(false);
					p.setFlying(false);
					
					p.sendMessage(Essentials.getInstance().pr + "§7Dein Flugmodus wurde §4Deaktiviert§7.");
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
					
				} else if(p.getAllowFlight() == false) {
					
					p.setAllowFlight(true);
					p.setFlying(true);
					
					p.sendMessage(Essentials.getInstance().pr + "§7Dein Flugmodus wurde §aAktiviert§7.");
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
					
				}
				
			} else if(args.length == 1) {
				
				String name = args[0];
				Player target = Bukkit.getPlayer(name);
				
				
				if(target != null) {
					
					
					if(target.getAllowFlight() == true) {
						
						target.setAllowFlight(false);
						target.setFlying(false);
						
						target.sendMessage(Essentials.getInstance().pr + "§7Dein Flugmodus wurde §4Deaktiviert§7.");
						target.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
						
						p.sendMessage(Essentials.getInstance().pr + "§7Du hast den Flugmodus von §r" + GlobalUtils.getRankColor(target) + target.getName() + " §4deaktiviert§7.");
						
					} else if(target.getAllowFlight() == false) {
						
						target.setAllowFlight(true);
						target.setFlying(true);
						
						target.sendMessage(Essentials.getInstance().pr + "§7Dein Flugmodus wurde §aAktiviert§7.");
						target.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
						
						p.sendMessage(Essentials.getInstance().pr + "§7Du hast den Flugmodus von §r" + GlobalUtils.getRankColor(target) + target.getName() + " §aaktiviert§7.");
						
					}
					
					
				} else {
					p.sendMessage(Essentials.getInstance().pr + "§cDieser Spieler ist nicht online!");
				}
				
				
			} else {
				p.sendMessage(Essentials.getInstance().pr + "§4Syntax§c: /fly §c§o<Spieler>");
			}
			
			
		} else {
			p.sendMessage(Essentials.getInstance().noPerm);
		}
		} 
		
		return true;
	}
	
	

}
