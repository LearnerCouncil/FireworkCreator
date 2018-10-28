package de.simagdo.fireworkcreator.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EffectGUI extends InventoryHandler {


    @Override
    public Inventory openInventory(Player player, int size, String inventoryName) {
        return null;
    }

    @Override
    public Inventory openInventory(int size, String inventoryName) {
        Inventory inventory = Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', inventoryName));

        inventory.setItem(12, createItemStack(Material.GLOWSTONE_DUST, 1, "&6Glowstone", "", "&7Click to choose Glowstone as an effect"));
        inventory.setItem(14, createItemStack(Material.DIAMOND, 1, "&6Diamond", "", "&7Click to choose Diamond as an effect"));
        inventory.setItem(30, back());
        inventory.setItem(32, result());

        return inventory;
    }
}
