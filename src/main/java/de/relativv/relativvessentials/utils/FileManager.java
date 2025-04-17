package de.relativv.relativvessentials.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {

    public static File file = new File("plugins/relativvEssentials", "warps.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void saveFile() {
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static File homeFile = new File("plugins/relativvEssentials", "homes.yml");
    public static FileConfiguration homeCfg = YamlConfiguration.loadConfiguration(homeFile);

    public static void saveHomes() {
        try {
            homeCfg.save(homeFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
