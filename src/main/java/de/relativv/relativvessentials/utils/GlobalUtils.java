package de.relativv.relativvessentials.utils;

import org.bukkit.entity.Player;

public class GlobalUtils {

    public static String getRankColor(Player p) {

        String clr = "";

        if(p.hasPermission("*") || p.hasPermission("system.owner")) {
            clr = "§4";
            return clr;
        } else if(p.hasPermission("system.admin")) {
            clr = "§4";
            return clr;
        } else if(p.hasPermission("system.dev")) {
            clr = "§3";
            return clr;
        } else if(p.hasPermission("system.srmod")) {
            clr = "§c";
            return clr;
        } else if(p.hasPermission("system.mod")) {
            clr = "§c";
            return clr;
        } else if(p.hasPermission("system.builder")) {
            clr = "§e";
            return clr;
        } else if(p.hasPermission("system.sup")) {
            clr = "§9";
            return clr;
        } else if(p.hasPermission("system.yt")) {
            clr = "§5";
            return clr;
        } else if(p.hasPermission("system.premium")) {
            clr = "§6";
            return clr;
        } else {
            clr = "§7";
            return clr;
        }
    }


    public static String getRankPrefix(Player p) {

        String prfx = "";


        if(p.hasPermission("*") || p.hasPermission("system.owner")) {
            prfx = "§4Owner §8| §4";

        } else if(p.hasPermission("system.admin")) {
            prfx = "§4Admin §8| §4";

        } else if(p.hasPermission("system.dev")) {
            prfx = "§3Dev §8| §3";

        } else if(p.hasPermission("system.srmod")) {
            prfx = "§cSrMod §8| §c";

        } else if(p.hasPermission("system.mod")) {
            prfx = "§cMod §8| §c";

        } else if(p.hasPermission("system.builder")) {
            prfx = "§eBuilder §8| §e";

        } else if(p.hasPermission("system.sup")) {
            prfx = "§9Sup §8| §9";

        } else if(p.hasPermission("system.yt")) {
            prfx = "§5YT §8| §5";

        } else if(p.hasPermission("system.premium")) {
            prfx = "§6";

        } else {
            prfx = "§7";
        }

        return prfx;
    }

}
