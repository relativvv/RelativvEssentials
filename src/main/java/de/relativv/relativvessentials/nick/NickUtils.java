package de.relativv.relativvessentials.nick;

import de.relativv.relativvessentials.main.Essentials;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.inventivetalent.nicknamer.NickNamer;


import java.util.ArrayList;
import java.util.HashMap;


public class NickUtils {

    public static HashMap<Player, String> realName = new HashMap<>();
    public static ArrayList<Player> isNicked = new ArrayList<>();
    public static HashMap<Player, String> wasNicked = new HashMap<>();


    public static boolean playerNicked(Player p) {
        return isNicked.contains(p);
    }


    public static void nickPlayer(Player p) {
        int randomNick = Essentials.getInstance().getRandomInt(0, Essentials.getInstance().nicknames.size())-1;
        int randomSkin = Essentials.getInstance().getRandomInt(0, Essentials.getInstance().nickSkins.size())-1;

        realName.put(p, p.getName());

        NickNamer.getNickManager().setNick(p.getUniqueId(), Essentials.getInstance().nicknames.get(randomNick));
        NickNamer.getNickManager().setSkin(p.getUniqueId(), Essentials.getInstance().nickSkins.get(randomSkin));



        isNicked.add(p);
        wasNicked.put(p, Essentials.getInstance().nicknames.get(randomNick));
    }





    public static void unnickPlayer(Player p) {
        String rName = realName.get(p);

        NickNamer.getNickManager().setNick(p.getUniqueId(), rName);
        NickNamer.getNickManager().setSkin(p.getUniqueId(), rName);
        NickNamer.getNickManager().removeSkin(p.getUniqueId());

        isNicked.remove(p);
        realName.remove(p);
    }

}

