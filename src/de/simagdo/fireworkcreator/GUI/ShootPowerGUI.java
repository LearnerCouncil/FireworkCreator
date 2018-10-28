package de.simagdo.fireworkcreator.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ShootPowerGUI extends InventoryHandler {

    @Override
    public Inventory openInventory(Player player, int size, String inventoryName) {
        return null;
    }

    @Override
    public Inventory openInventory(int size, String inventoryName) {
        Inventory inventory = Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', inventoryName));

        inventory.setItem(11, createItemStack(Material.FIREWORK_ROCKET, 1, "&6Low Power", "", "&7Click to select Low Power"));
        inventory.setItem(13, createItemStack(Material.FIREWORK_ROCKET, 2, "&6Medium Power", "", "&7Click to select Medium Power"));
        inventory.setItem(15, createItemStack(Material.FIREWORK_ROCKET, 3, "&6High Power", "", "&7Click to select High Power"));
        inventory.setItem(30, back());
        inventory.setItem(32, result());

        return inventory;
    }
}
