package com.perceivedev.playerhousing.housing;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;

/**
 * Created by jan on 9/30/16.
 */
public class House {
    /* House Schematic? */
    private Location   houseSpawnPoint;
    private Location   houseLocation;
    private boolean    locked;
    private List<UUID> banned;

    public House(Location houseLocation, Location houseSpawnPoint, File schematic) {
        this.houseSpawnPoint = houseSpawnPoint;
        this.houseLocation = houseLocation;
        HousingManager.getInstance().generateHouse(houseLocation, schematic);
    }

    public Location houseSpawnLocation() {
        return houseSpawnPoint;
    }

    public Location houseLocation() {
        return houseLocation;
    }

}
