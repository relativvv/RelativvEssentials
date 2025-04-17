package de.relativv.relativvessentials.listener;

import de.relativv.relativvessentials.main.Essentials;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Timber implements Listener {

    private Essentials plugin;
    public Timber(Essentials plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCut(BlockBreakEvent e) {
        Player p = e.getPlayer();

        if(p.getItemInHand().getType() == Material.WOODEN_AXE || p.getItemInHand().getType() == Material.STONE_AXE || p.getItemInHand().getType() == Material.IRON_AXE ||
                p.getItemInHand().getType() == Material.GOLDEN_AXE || p.getItemInHand().getType() == Material.DIAMOND_AXE) {

            if (e.getBlock().getType() == Material.OAK_LOG || e.getBlock().getType() == Material.BIRCH_LOG || e.getBlock().getType() == Material.ACACIA_LOG || e.getBlock().getType() == Material.JUNGLE_LOG
                    || e.getBlock().getType() == Material.DARK_OAK_LOG || e.getBlock().getType() == Material.SPRUCE_LOG) {
                if(!p.isSneaking()) {

                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);

                    for(int y = e.getBlock().getY(); y <= e.getBlock().getWorld().getHighestBlockYAt(e.getBlock().getX(), e.getBlock().getZ()); y++) {
                        Location nLoc = new Location(e.getBlock().getWorld(), e.getBlock().getX(), y, e.getBlock().getZ());

                        if (nLoc.getBlock().getType() == Material.OAK_LOG || nLoc.getBlock().getType() == Material.BIRCH_LOG || nLoc.getBlock().getType() == Material.ACACIA_LOG || nLoc.getBlock().getType() == Material.JUNGLE_LOG
                                || nLoc.getBlock().getType() == Material.DARK_OAK_LOG || nLoc.getBlock().getType() == Material.SPRUCE_LOG) {

                            nLoc.getBlock().breakNaturally();

                            short newDur = (short) ((short) p.getItemInHand().getDurability()+1);
                            p.getItemInHand().setDurability(newDur);

                            nLoc.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, nLoc.getX(),
                                    nLoc.getY(),
                                    nLoc.getZ(),
                                    15, 0.4, 0.3, 0.4, 0);

                    }
                    }
                }
            }
        }
    }
}
