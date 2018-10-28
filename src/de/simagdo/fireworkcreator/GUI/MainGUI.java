package de.simagdo.fireworkcreator.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MainGUI extends InventoryHandler {

    @Override
    public Inventory openInventory(Player player, int size, String inventoryName) {
        return null;
    }

    @Override
    public Inventory openInventory(int size, String inventoryName) {
        Inventory inventory = Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', inventoryName));

        inventory.setItem(11, createItemStack(Material.INK_SAC, 1, "&6Choose the Firework Colors", "", "&7Click to choose the Firework colors"));
        inventory.setItem(13, createItemStack(Material.INK_SAC, 1, "&6Choose the Fading Colors", "", "&7Click to choose the Fading colors",
                "&7These will be fading after the first colors"));
        inventory.setItem(15, createItemStack(Material.FIRE_CHARGE, 1, "&6Choose the Explosion shape", "", "&7Click to choose the Explosion shape"));
        //inventory.setItem(30, createItemStack(Material.DIAMOND, 1, "&6Choose the Effect", "", "&7Click to choose the Effect"));
        inventory.setItem(30, createItemStack(Material.FIREWORK_ROCKET, 16, "&6Choose the amount", "", "&7Click to choose the amount of Firework Rockets you get"));
        inventory.setItem(32, createItemStack(Material.GUNPOWDER, 1, "&6Choose the Shooting Power", "", "&7Click to choose the Shooting Power"));
        inventory.setItem(49, result());

        return inventory;
    }

}
