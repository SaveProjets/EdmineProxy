package fr.edminecoreteam.proxyapi.maintenance;

import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import java.io.IOException;
import net.md_5.bungee.config.Configuration;
import java.io.File;

public class Manager
{
    public static File file;
    public static Configuration cfg;

    public static void init() {
        File ord = new File("plugins/API");
        if (!ord.exists()) {
            ord.mkdir();
        }
        Manager.file = new File("plugins/API", "maintenance.yml");
        if (!Manager.file.exists()) {
            try {
                Manager.file.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Manager.cfg = ConfigurationProvider.getProvider(YamlConfiguration.class).load(Manager.file);
            if (!Manager.cfg.contains("maintenance.isInMaintenance")) {
                Manager.cfg.set("maintenance.isInMaintenance", (Object)false);
                Manager.cfg.set("maintenance.justAdmin", (Object)false);
                Manager.cfg.set("maintenance.motdFirstLine", (Object)"         &4&kII&r &cMaintenance du Edmine-Proxy...&r &4&kII&r ");
                Manager.cfg.set("maintenance.motdSecondLine", (Object)"    &8» &7Plus d'informations sur &b&nhttps://edmine.net&r &8«");
                Manager.cfg.set("motd.FirstLine", (Object)"          &e&kII&r &6&lEDMINE &f&l&oNETWORK&r &e&kII&r &7➡ &f[1.8&8-&f1.18]");
                Manager.cfg.set("motd.SecondLine", (Object)"    &8» &7Plus d'informations sur &b&nhttps://edmine.net&r &8«");
                save();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(Manager.cfg, Manager.file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
