package de.relativv.relativvessentials.main;

import de.relativv.relativvessentials.commands.*;
import de.relativv.relativvessentials.listener.*;
import de.relativv.relativvessentials.nick.NickAPI;
import de.relativv.relativvessentials.utils.CreditAPI;
import de.relativv.relativvessentials.utils.MySQL;
import de.relativv.relativvessentials.utils.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public final class Essentials extends JavaPlugin {

    public String pr;
    public String noPerm;
    public MySQL sql;
    public static Essentials instance;
    public CreditAPI creditAPI;
    public NickAPI nickAPI;

    public ArrayList<String> nicknames;
    public ArrayList<String> nickSkins;

    @Override
    public void onEnable() {
        instance = this;

        ConsoleCommandSender cs = Bukkit.getConsoleSender();

        pr = "§8▌ §3System §8» §r";
        noPerm = pr + "§cDu hast keine Berechtigung für diese Aktion!";

        Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new QuitListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new AsyncPlayerChat(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new DeathListener(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ServerListPing(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Timber(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new CreatureSpawn(this), this);

        ScoreboardManager.startUpdater();

        nicknames = new ArrayList<>();
        nickSkins = new ArrayList<>();

        registerNicknames();

        sql = new MySQL();
        sql.connect("localhost", "test", "testt", "test123", "3306");

        nickAPI = new NickAPI();
        nickAPI.createTables();

        creditAPI = new CreditAPI();

        this.getCommand("fly").setExecutor(new Fly());
        this.getCommand("gm").setExecutor(new Gamemode(this));
        this.getCommand("credits").setExecutor(new Credits(this));
        this.getCommand("tp").setExecutor(new Teleport(this));
        this.getCommand("tphere").setExecutor(new TeleportHere(this));
        this.getCommand("warp").setExecutor(new Warp(this));
        this.getCommand("warp").setTabCompleter(new Warp(this));
        this.getCommand("setwarp").setExecutor(new SetWarp(this));
        this.getCommand("day").setExecutor(new Day(this));
        this.getCommand("delwarp").setExecutor(new DelWarp(this));
        this.getCommand("delwarp").setTabCompleter(new DelWarp(this));
        this.getCommand("night").setExecutor(new Night(this));
        this.getCommand("tpa").setExecutor(new TPA(this));
        this.getCommand("tpaccept").setExecutor(new Tpaccept(this));
        this.getCommand("tpdeny").setExecutor(new Tpdeny(this));
        this.getCommand("vanish").setExecutor(new Vanish(this));
        this.getCommand("home").setExecutor(new Home(this));
        this.getCommand("sethome").setExecutor(new SetHome(this));
        this.getCommand("delhome").setExecutor(new DelHome(this));
        this.getCommand("nick").setExecutor(new Nick(this));





        cs.sendMessage("§e======================");
        cs.sendMessage(" ");
        cs.sendMessage("§3Author§8: §e" + this.getDescription().getAuthors());
        cs.sendMessage("§3Version§8: §e" + this.getDescription().getVersion());
        cs.sendMessage(" ");
        cs.sendMessage("§a§lEnabled");
        cs.sendMessage(" ");
        cs.sendMessage("§e======================");
    }



    @Override
    public void onDisable() {
        ConsoleCommandSender cs = Bukkit.getConsoleSender();
        cs.sendMessage("§e======================");
        cs.sendMessage(" ");
        cs.sendMessage("§3Author§8: §e" + this.getDescription().getAuthors());
        cs.sendMessage("§3Version§8: §e" + this.getDescription().getVersion());
        cs.sendMessage(" ");
        cs.sendMessage("§4§lDisabled");
        cs.sendMessage(" ");
        cs.sendMessage("§e======================");    }



    public static Essentials getInstance() {
        return instance;
    }

    public int getRandomInt(int min, int max) {
        Random rnd = new Random();
        return rnd.nextInt((max-min)+1)+min;
    }






    private void registerNicknames() {
        nicknames.add("BowSpammer4235");
        nicknames.add("AUTOmat");
        nicknames.add("Fantasaufen35");
    }

}
