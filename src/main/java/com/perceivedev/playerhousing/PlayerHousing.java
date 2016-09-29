/**
 * 
 */
package com.perceivedev.playerhousing;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Rayzr
 *
 */
public class PlayerHousing extends JavaPlugin {

    private Logger logger;

    @Override
    public void onEnable() {
        logger = getLogger();

        logger.info(versionText() + " enabled");
    }

    @Override
    public void onDisable() {
        logger.info(versionText() + " disabled");
    }

    public String versionText() {
        return getName() + " v" + getDescription().getVersion();
    }

}
