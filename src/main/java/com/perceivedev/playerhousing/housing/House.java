package com.perceivedev.playerhousing.housing;


import org.bukkit.Location;

/**
 * Created by jan on 9/30/16.
 */
public class House {
    /*House Schematic?*/
    private Location houseSpawnPoint;
    private Location houseLocation;

    public House(Location houseLocation, Location houseSpawnPoint) {
        this.houseSpawnPoint = houseSpawnPoint;
        this.houseLocation = houseLocation;
    }

    public Location houseSpawnLocation() {
        return houseSpawnPoint;
    }

    public Location houseLocation() {
        return houseLocation;
    }

}
