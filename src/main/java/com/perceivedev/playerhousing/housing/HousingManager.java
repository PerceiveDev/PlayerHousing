package com.perceivedev.playerhousing.housing;

import com.sk89q.worldedit.schematic.SchematicFormat;
import org.bukkit.Location;

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

    public void generateHouse(Location houseLocation, SchematicFormat schematicFormat) {
        // Do stuff.

    }
}
