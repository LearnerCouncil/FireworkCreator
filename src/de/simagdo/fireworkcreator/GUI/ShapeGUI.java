package de.simagdo.fireworkcreator.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ShapeGUI extends InventoryHandler {

    @Override
    public Inventory openInventory(Player player, int size, String inventoryName) {
        return null;
    }

    @Override
    public Inventory openInventory(int size, String inventoryName) {
        Inventory inventory = Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', inventoryName));

        inventory.setItem(11, createItemStack(Material.BUCKET, 1, "&6None"));
        inventory.setItem(13, createItemStack(Material.FIRE_CHARGE, 1, "&6Fire Charge", "", "&7Click to choose Fire Charge as an explosion shape"));
        inventory.setItem(15, createItemStack(Material.GOLD_NUGGET, 1, "&6Gold Nugget", "", "&7Click to choose Gold Nugget as an explosion shape"));
        inventory.setItem(30, createItemStack(Material.CREEPER_HEAD, 1, "&6Creeper Head", "", "&7Click to choose Creepeer Head as an explosion shape"));
        inventory.setItem(32, createItemStack(Material.FEATHER, 1, "&6Feather", "", "&7Click to choose Feather as an explosion shape"));
        inventory.setItem(48, back());
        inventory.setItem(50, result());

        return inventory;
    }
}
