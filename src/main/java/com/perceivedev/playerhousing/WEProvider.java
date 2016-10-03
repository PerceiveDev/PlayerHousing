/**
 * 
 */
package com.perceivedev.playerhousing;

import org.bukkit.Bukkit;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

/**
 * @author Rayzr
 *
 */
public class WEProvider {
    
    public static WorldEditPlugin getInstance() {
        
        WorldEditPlugin plugin = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
        if (plugin == null) {
            throw new IllegalStateException("Could not find WorldEdit! Is it installed?");
        }
        
        return plugin;
        
    }

}
