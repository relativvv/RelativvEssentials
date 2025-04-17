package de.relativv.relativvessentials.utils;

import de.relativv.relativvessentials.main.Essentials;
import de.relativv.relativvessentials.nick.NickUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.inventivetalent.nicknamer.NickNamer;

public class ScoreboardManager {

    private static Essentials plugin;
    public ScoreboardManager(Essentials plugin) {
        this.plugin = plugin;
    }


    public static void setScoreboard(Player p) {
        Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = sb.getObjective("aaa");
        if(obj == null) {
            obj = sb.registerNewObjective("aaa", "bbb");
        }

        //Owner
        //Admin
        //Dev
        //Moderator
        //Builder
        //Supporter
        //Youtuber
        //Majin
        //Spieler

        Team owner = getTeam(sb, "0000Owner", "§4Owner §8| §4", "§4", ChatColor.DARK_RED);
        Team admin = getTeam(sb, "0001Admin", "§4Admin §8| §4", "§4", ChatColor.DARK_RED);
        Team dev = getTeam(sb, "0002Developer", "§bDev §8| §b", "§b", ChatColor.AQUA);
        Team mod = getTeam(sb, "0003Moderator", "§cMod §8| §c", "§c", ChatColor.RED);
        Team builder = getTeam(sb, "0004Builder", "§d", "§d", ChatColor.LIGHT_PURPLE);
        Team sup = getTeam(sb, "0005Supporter", "§9", "§9", ChatColor.BLUE);
        Team yt = getTeam(sb, "0006Youtuber", "§5", "§5", ChatColor.DARK_PURPLE);
        Team premium = getTeam(sb, "0007Premium", "§6", "§6", ChatColor.GOLD);
        Team user = getTeam(sb, "0008User", "§7", "§7", ChatColor.GRAY);

        for (Player all : Bukkit.getOnlinePlayers()) {
            if(NickUtils.playerNicked(all)) {
                premium.addPlayer(all);
                all.setDisplayName("§6" + NickNamer.getNickManager().getNick(all.getUniqueId()));
                all.setPlayerListName("§6" + NickNamer.getNickManager().getNick(all.getUniqueId()));

            } else {
                if (all.hasPermission("system.owner") || all.isOp()) {
                    owner.addPlayer(all);
                    all.setDisplayName("§4Owner §8| §4" + all.getName());
                    all.setPlayerListName("§4Owner §8| §4" + all.getName());

                } else if (all.hasPermission("system.admin")) {
                    admin.addPlayer(all);
                    all.setDisplayName("§4Admin §8| §4" + all.getName());
                    all.setPlayerListName("§4Admin §8| §4" + all.getName());

                } else if (all.hasPermission("system.dev")) {
                    dev.addPlayer(all);
                    all.setDisplayName("§bDev §8| §b" + all.getName());
                    all.setPlayerListName("§bDev §8| §b" + all.getName());

                } else if (all.hasPermission("system.mod")) {
                    mod.addPlayer(all);
                    all.setDisplayName("§cMod §8| §c" + all.getName());
                    all.setPlayerListName("§cMod §8| §c" + all.getName());

                } else if (all.hasPermission("system.builder")) {
                    builder.addPlayer(all);
                    all.setDisplayName("§e" + all.getName());
                    all.setPlayerListName("§e" + all.getName());

                } else if (all.hasPermission("system.sup")) {
                    sup.addPlayer(all);
                    all.setDisplayName("§9" + all.getName());
                    all.setPlayerListName("§9" + all.getName());

                } else if (all.hasPermission("system.yt")) {
                    yt.addPlayer(all);
                    all.setDisplayName("§5" + all.getName());
                    all.setPlayerListName("§5" + all.getName());

                } else if (all.hasPermission("system.premium")) {
                    premium.addPlayer(all);
                    all.setDisplayName("§6" + all.getName());
                    all.setPlayerListName("§6" + all.getName());

                } else {
                    user.addPlayer(all);
                    all.setDisplayName("§7" + all.getName());
                    all.setPlayerListName("§7" + all.getName());
                }
            }
        }

        p.setScoreboard(sb);
    }




    public static void updateScoreboard(Player p) {
        if(p.getScoreboard() == null) {
            setScoreboard(p);
        }
        Scoreboard sb = p.getScoreboard();
        Objective obj = sb.getObjective("aaa");
        if(obj == null) {
            obj = sb.registerNewObjective("aaa", "bbb");
        }

        Team owner = getTeam(sb, "0000Owner", "§4Owner §8| §4", "§4", ChatColor.DARK_RED);
        Team admin = getTeam(sb, "0001Admin", "§4Admin §8| §4", "§4", ChatColor.DARK_RED);
        Team dev = getTeam(sb, "0002Developer", "§bDev §8| §b", "§b", ChatColor.AQUA);
        Team mod = getTeam(sb, "0003Moderator", "§cMod §8| §c", "§c", ChatColor.RED);
        Team builder = getTeam(sb, "0004Builder", "§d", "§d", ChatColor.LIGHT_PURPLE);
        Team sup = getTeam(sb, "0005Supporter", "§9", "§9", ChatColor.BLUE);
        Team yt = getTeam(sb, "0006Youtuber", "§5", "§5", ChatColor.DARK_PURPLE);
        Team premium = getTeam(sb, "0007Premium", "§6", "§6", ChatColor.GOLD);
        Team user = getTeam(sb, "0008User", "§7", "§7", ChatColor.GRAY);

        for (Player all : Bukkit.getOnlinePlayers()) {
            if(NickUtils.playerNicked(all)) {
                premium.addPlayer(all);
                all.setDisplayName("§6" + NickNamer.getNickManager().getNick(all.getUniqueId()));
                all.setPlayerListName("§6" + NickNamer.getNickManager().getNick(all.getUniqueId()));

            } else {
                if (all.hasPermission("system.owner") || all.isOp()) {
                    owner.addPlayer(all);
                    all.setDisplayName("§4Owner §8| §4" + all.getName());
                    all.setPlayerListName("§4Owner §8| §4" + all.getName());

                } else if (all.hasPermission("system.admin")) {
                    admin.addPlayer(all);
                    all.setDisplayName("§4Admin §8| §4" + all.getName());
                    all.setPlayerListName("§4Admin §8| §4" + all.getName());

                } else if (all.hasPermission("system.dev")) {
                    dev.addPlayer(all);
                    all.setDisplayName("§bDev §8| §b" + all.getName());
                    all.setPlayerListName("§bDev §8| §b" + all.getName());

                } else if (all.hasPermission("system.mod")) {
                    mod.addPlayer(all);
                    all.setDisplayName("§cMod §8| §c" + all.getName());
                    all.setPlayerListName("§cMod §8| §c" + all.getName());

                } else if (all.hasPermission("system.builder")) {
                    builder.addPlayer(all);
                    all.setDisplayName("§e" + all.getName());
                    all.setPlayerListName("§e" + all.getName());

                } else if (all.hasPermission("system.sup")) {
                    sup.addPlayer(all);
                    all.setDisplayName("§9" + all.getName());
                    all.setPlayerListName("§9" + all.getName());

                } else if (all.hasPermission("system.yt")) {
                    yt.addPlayer(all);
                    all.setDisplayName("§5" + all.getName());
                    all.setPlayerListName("§5" + all.getName());

                } else if (all.hasPermission("system.premium")) {
                    premium.addPlayer(all);
                    all.setDisplayName("§6" + all.getName());
                    all.setPlayerListName("§6" + all.getName());

                } else {
                    user.addPlayer(all);
                    all.setDisplayName("§7" + all.getName());
                    all.setPlayerListName("§7" + all.getName());
                }
            }
        }


    }



    public static Team getTeam(Scoreboard sb, String t, String prefix, String suffix, ChatColor color) {
        Team team = sb.getTeam(t);
        if(team == null) {
            team = sb.registerNewTeam(t);
        }
        team.setColor(color);
        team.setPrefix(prefix);
        team.setSuffix(suffix);
        return sb.getTeam(t);
    }


    public static String updateTeam(Scoreboard sb, String t, String prefix, String suffix, ChatColor entry) {
        Team team = sb.getTeam(t);
        if(team == null) {
            team = sb.registerNewTeam(t);
        }
        team.setPrefix(prefix);
        team.setSuffix(suffix);
        team.addEntry(entry.toString());
        return entry.toString();
    }


    public static void startUpdater() {
        Bukkit.getConsoleSender().sendMessage("§3Scoreboard Updater§8: §aEnabled");
        new BukkitRunnable() {

            @Override
            public void run() {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    updateScoreboard(all);
                }
            }

        }.runTaskTimer(Essentials.getInstance(), 20, 60);
    }


    public static String getRank(Player p) {
        if(p.hasPermission("system.owner") || p.isOp()) {
            return "§4Owner";
        } else if(p.hasPermission("system.admin")) {
            return "§4Admin";
        } else if(p.hasPermission("system.dev")) {
            return "§bDeveloper";
        } else if(p.hasPermission("system.mod")) {
            return "§cModerator";
        } else if(p.hasPermission("system.builder")) {
            return "§eBuilder";
        } else if(p.hasPermission("system.sup")) {
            return "§9Supporter";
        } else if(p.hasPermission("system.yt")) {
            return "§5Youtuber";
        } else if(p.hasPermission("system.premium")) {
            return "§6Premium";
        } else {
            return "§7User";
        }
    }

}
