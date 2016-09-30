package com.perceivedev.playerhousing.housing;


import com.sk89q.worldedit.schematic.SchematicFormat;
import org.bukkit.Location;

/**
 * Created by jan on 9/30/16.
 */
public class House {
    /*House Schematic?*/
    private Location houseSpawnPoint;
    private Location houseLocation;

    public House(Location houseLocation, Location houseSpawnPoint, SchematicFormat schematic) {
        this.houseSpawnPoint = houseSpawnPoint;
        this.houseLocation = houseLocation;
        HousingManager.getHousingManager().generateHouse(houseLocation, schematic); // Is this the right Schematic?
    }

    public Location houseSpawnLocation() {
        return houseSpawnPoint;
    }

    public Location houseLocation() {
        return houseLocation;
    }

}
