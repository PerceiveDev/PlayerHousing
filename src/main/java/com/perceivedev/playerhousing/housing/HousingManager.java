package com.perceivedev.playerhousing.housing;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import com.perceivedev.playerhousing.WEProvider;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import com.sk89q.worldedit.world.DataException;

/**
 * Created by jan on 9/30/16.
 */
public class HousingManager {
    private static HousingManager instance;
    public HashMap<UUID, User>    housingMap = new HashMap<UUID, User>();

    public HousingManager() {
        instance = this;
    }

    public static HousingManager getInstance() {
        return instance;
    }

    public List<House> playerHouses(UUID uniquePlayerID) {

        if (this.housingMap.containsKey(uniquePlayerID)) {

            User user = housingMap.get(uniquePlayerID);
            if (user == null) {
                return null;
            }

            return user.getHouses();

        }

        return null;

    }

    public void newHouse(UUID uniquePlayerID) {
        // Update this.
        // This is a test use the other function when they are finished
        // Example House house = new
        // House(HousingManager.getHousingManager().getValidHouseSpot(),
        // HousingManager.getHousingManager().getValidSpawnLocation(), null);
        // Test
        // Player player = Bukkit.getPlayer(uniquePlayerID);
        // House house = new House(player.getLocation(), player.getLocation(),
        // new
        // File("/home/jan/Desktop/Minecraft-Server/plugins/WorldEdit/schematics/test.schematic"));
        Player player = Bukkit.getPlayer(uniquePlayerID);
        Location validHouseSpot = getValidHouseSpot();
        Location validHouseSpawnSpot = getValidSpawnLocation(validHouseSpot);
        // TODO COMPILE A SCHEMATIC WITH THE .JAR FILE
        House house = new House(validHouseSpot, validHouseSpawnSpot, new File("plugins/WorldEdit/schematics/default.schematic"));
        player.teleport(house.houseSpawnLocation());
    }

    public Location getValidHouseSpot() {
        // Use some math here.
        // This is not good enough we need to find something better but good
        // enough for now
        int numHouses = housingMap.size();
        int gridSize = 0;
        while (numHouses <= gridSize) {
            gridSize++;
        }
        int nextPos = numHouses + 1;
        int x = nextPos % gridSize;
        int y = nextPos / gridSize;
        Location location = new Location(Bukkit.getWorld("HousingWorld"), x * 10000D, 64, y * 10000D);
        return location;
    }

    public Location getValidSpawnLocation(Location location) {

        for (double x = (location.getX() - 15); x < location.getX() + 15; x++) {

            for (double y = location.getY() - 15; y < location.getY() + 15; y++) {

                for (double z = location.getZ() - 15; z < location.getZ() + 15; z++) {

                    Location temporaryLocation = new Location(location.getWorld(), x, y, z);
                    Block block = temporaryLocation.getBlock();

                    if (block.getType().isSolid() && !block.getRelative(0, 1, 0).getType().isSolid() && !block.getRelative(0, 1, 0).getType().isSolid()) {
                        return temporaryLocation.add(0, 1, 0);
                    }

                }

            }

        }

        return location;

    }

    @SuppressWarnings("deprecation")
    public void generateHouse(Location houseLocation, File schematic) {
        WorldEditPlugin we = WEProvider.getInstance();
        EditSession session = we.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(houseLocation.getWorld()), 1000000);
        try {
            MCEditSchematicFormat.getFormat(schematic).load(schematic).paste(session, new Vector(houseLocation.getX(), houseLocation.getY(), houseLocation.getZ()), false);
        } catch (MaxChangedBlocksException | DataException | IOException e) {
            e.printStackTrace();
        }
    }
}
