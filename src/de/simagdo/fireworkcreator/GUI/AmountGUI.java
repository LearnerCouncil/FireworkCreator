package de.simagdo.fireworkcreator.GUI;

import de.simagdo.fireworkcreator.system.FireworkCreator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class AmountGUI extends InventoryHandler {

    @Override
    public Inventory openInventory(Player player, int size, String inventoryName) {
        return null;
    }

    @Override
    public Inventory openInventory(int size, String inventoryName) {
        Inventory inventory = Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', inventoryName));

        inventory.setItem(11, createItemStack(Material.FIREWORK_ROCKET, 16, "&6Firework 16x", "", "&7Click to get 16 Firework Rockets"));
        inventory.setItem(13, createItemStack(Material.FIREWORK_ROCKET, 32, "&6Firework 32x", "", "&7Click to get 32 Firework Rockets"));
        inventory.setItem(15, createItemStack(Material.FIREWORK_ROCKET, 48, "&6Firework 48x", "", "&7Click to get 48 Firework Rockets"));
        inventory.setItem(30, createItemStack(Material.FIREWORK_ROCKET, 64, "&6Firework 64x", "", "&7Click to get 64 Firework Rockets"));
        inventory.setItem(32, createItemStack(Material.FIREWORK_ROCKET, 1, "&6Firework custom " + FireworkCreator.crafter.getAmount() + "x", "", "&7Left Click: &bIncrease Amount by 1",
                "&7Right Click: &b Decrease Amount by 1",
                "&7Shift Left Click: &bIncrease Amount by 16",
                "&7Shift Right Click: &bDecrease Amount by 16"));
        inventory.setItem(48, back());
        inventory.setItem(50, result());

        return inventory;
    }
}
