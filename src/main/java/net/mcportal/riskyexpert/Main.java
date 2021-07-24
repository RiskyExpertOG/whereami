package net.mcportal.riskyexpert;

import net.mcportal.riskyexpert.commands.modify;
import net.mcportal.riskyexpert.commands.reload;
import net.mcportal.riskyexpert.commands.whereami;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class Main extends JavaPlugin {
    Logger logger = this.getLogger();
    final FileConfiguration config = this.getConfig();
    @Override
    public void onEnable(){
        this.getCommand("whereami").setExecutor(new whereami(this));
        this.getCommand("whereami-reload").setExecutor(new reload(this));
        this.getCommand("whereami-set").setExecutor(new modify(this));
        this.logger.info("Whereami enabled!");
        config.addDefault("servername", "server_name_goes_here");
        config.options().copyDefaults(true);
        saveConfig();
    }

}
