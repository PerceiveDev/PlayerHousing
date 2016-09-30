package com.perceivedev.playerhousing.housing;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by jan on 9/30/16.
 */
public class HousingManager {
    private static HousingManager instance;
    public HashMap<UUID, User> housingMap = new HashMap<UUID, User>();

    public HousingManager() {
        instance = this;
    }

    public static HousingManager getHousingManager() {
        return instance;
    }

    public List<House> playerHouses(UUID uniquePlayerID) {
        if (this.housingMap.containsKey(uniquePlayerID)) {
            return housingMap.get(uniquePlayerID).returnHouses();
        }
        return null;
    }

    public void newHouse(UUID uniquePlayerID) {
        // Update this.
        House house = new House(HousingManager.getHousingManager().getValidHouseSpot(), HousingManager.getHousingManager().getValidSpawnLocation(), null);

    }

    public Location getValidHouseSpot() {
        // Use some math here.
        return null;
    }

    public Location getValidSpawnLocation() {
        // Some more math here
        return null;
    }


    @SuppressWarnings("deprecation")
    public void generateHouse(Location houseLocation, File schematic) {
        WorldEditPlugin we = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
        EditSession session = we.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(houseLocation.getWorld()), 1000000);
        try {
            MCEditSchematicFormat.getFormat(schematic).load(schematic).paste(session, new Vector(houseLocation.getX(), houseLocation.getY(), houseLocation.getZ()), false);
        } catch (MaxChangedBlocksException
                | com.sk89q.worldedit.data.DataException | IOException e2) {
            e2.printStackTrace();
        }
    }
}
