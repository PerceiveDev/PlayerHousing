package com.perceivedev.playerhousing.housing;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by jan on 9/30/16.
 */
public class HousingCommand implements CommandExecutor {
    private HousingManager housingManager = HousingManager.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        // Lets switch to make it look nice
        if (args.length == 0) {
            player.sendMessage("Generating house");
            housingManager.newHouse(player.getUniqueId());
            return true;
        }
        String subCommand = args[0];
        switch (subCommand) {
            default:
                break;

            // Add other coommands
        }
        return true;
    }
}
