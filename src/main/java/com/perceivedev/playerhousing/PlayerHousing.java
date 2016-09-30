/**
 *
 */
package com.perceivedev.playerhousing;

import com.perceivedev.playerhousing.housing.HousingCommand;
import com.perceivedev.playerhousing.housing.HousingManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Rayzr
 */
// Gotta take a break hope someone continues - Jan ;)
public class PlayerHousing extends JavaPlugin {

    // Register Housing Manager do not make a new class instance of this any other place. You can move this.
    private HousingManager housingManager = new HousingManager();

    @Override
    public void onEnable() {
        // Tested Schematic function WORKS!!! housingManager.generateHouse(Bukkit.getWorlds().get(0).getSpawnLocation(),new File("/home/jan/Desktop/Minecraft-Server/plugins/WorldEdit/schematics/test.schematic"));
        getLogger().info(versionText() + " enabled");
        getCommand("house").setExecutor(new HousingCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info(versionText() + " disabled");
    }

    public String versionText() {
        return getName() + " v" + getDescription().getVersion();
    }

}
