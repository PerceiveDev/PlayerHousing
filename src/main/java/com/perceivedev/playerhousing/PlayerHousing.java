/**
 *
 */
package com.perceivedev.playerhousing;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.utils.WorldManager;
import com.perceivedev.playerhousing.housing.HousingCommand;
import com.perceivedev.playerhousing.housing.HousingManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 */
public class PlayerHousing extends JavaPlugin {

    private static WorldManager wm;
    // Register Housing Manager do not make a new class instance of this any
    // other place. You can move this.
    private HousingManager      housingManager = new HousingManager();

    public static WorldManager getMultiverseWorldManager() {
        return wm;
    }

    @Override
    public void onEnable() {
        wm = new WorldManager(getMultiverseCore());
        try {
            boolean world = wm.isMVWorld("HousingWorld");
            if (!world) {
                getLogger().info("Generating HousingWorld... ");
                wm.addWorld("HousingWorld", World.Environment.NORMAL, "-7261691309120837834", WorldType.FLAT, false, "CleanroomGenerator:.");
            } else {
                wm.loadWorld("HousingWorld");
            }
        } catch (NullPointerException e) {
            getLogger().info("Multiverse returned a nullpointer under creation or loading of HousingWorld. Shouldn't affect a thing");
        }
        // Tested Schematic function WORKS!!!
        // housingManager.generateHouse(Bukkit.getWorlds().get(0).getSpawnLocation(),new
        // File("/home/jan/Desktop/Minecraft-Server/plugins/WorldEdit/schematics/test.schematic"));

        getCommand("house").setExecutor(new HousingCommand());
        getLogger().info(versionText() + " enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info(versionText() + " disabled");
    }

    public String versionText() {
        return getName() + " v" + getDescription().getVersion();
    }

    public MultiverseCore getMultiverseCore() {
        Plugin plugin = getServer().getPluginManager().getPlugin("Multiverse-Core");

        if (plugin instanceof MultiverseCore) {
            return (MultiverseCore) plugin;
        }
        Bukkit.getPluginManager().disablePlugin(this);
        throw new RuntimeException("MultiVerse not found!");

    }

    /**
     * @return the housing manager
     */
    public HousingManager getHousingManager() {
        return housingManager;
    }

}
