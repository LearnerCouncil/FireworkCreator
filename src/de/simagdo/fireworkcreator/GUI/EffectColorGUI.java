package de.simagdo.fireworkcreator.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EffectColorGUI extends InventoryHandler {

    private String title;

    public EffectColorGUI(String title) {
        this.title = title;
    }

    @Override
    public Inventory openInventory(Player player, int size, String inventoryName) {
        return null;
    }

    @Override
    public Inventory openInventory(int size, String inventoryName) {
        Inventory inventory = Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', inventoryName));

        //First Column
        inventory.setItem(10, createItemStack(Material.BONE_MEAL, 1, "&6White", "", "&7Click to select White as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.WHITE.getRed() + " &a" + Color.WHITE.getGreen() + " &b" + Color.WHITE.getBlue() + "&7)"));
        inventory.setItem(19, createItemStack(Material.LIGHT_GRAY_DYE, 1, "&6Silver", "", "&7Click to select Light Gray as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.SILVER.getRed() + " &a" + Color.SILVER.getGreen() + " &b" + Color.SILVER.getBlue() + "&7)"));
        inventory.setItem(28, createItemStack(Material.GRAY_DYE, 1, "&6Gray", "", "&7Click to select Gray as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.GRAY.getRed() + " &a" + Color.GRAY.getGreen() + " &b" + Color.GRAY.getBlue() + "&7)"));
        inventory.setItem(37, createItemStack(Material.INK_SAC, 1, "&6Black", "", "&7Click to select Black as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.BLACK.getRed() + " &a" + Color.BLACK.getGreen() + " &b" + Color.BLACK.getBlue() + "&7)"));

        //Second Column
        inventory.setItem(12, createItemStack(Material.LIGHT_BLUE_DYE, 1, "&6Teal", "", "&7Click to select Light Blue as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.TEAL.getRed() + " &a" + Color.TEAL.getGreen() + " &b" + Color.TEAL.getBlue() + "&7)"));
        inventory.setItem(21, createItemStack(Material.CYAN_DYE, 1, "&6Navy", "", "&7Click to select Cyan as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.NAVY.getRed() + " &a" + Color.NAVY.getGreen() + " &b" + Color.NAVY.getBlue() + "&7)"));
        inventory.setItem(30, createItemStack(Material.LAPIS_LAZULI, 1, "&6Blue", "", "&7Click to select Lapis Lazuli as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.BLUE.getRed() + " &a" + Color.BLUE.getGreen() + " &b" + Color.BLACK.getBlue() + "&7)"));
        inventory.setItem(39, createItemStack(Material.COCOA_BEANS, 1, "&6Maroon", "", "&7Click to select Brown as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.MAROON.getRed() + " &a" + Color.MAROON.getGreen() + " &b" + Color.MAROON.getBlue() + "&7)"));

        //Third Column
        inventory.setItem(14, createItemStack(Material.LIME_DYE, 1, "&6Lime", "", "&7Click to select Lime as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.LIME.getRed() + " &a" + Color.LIME.getGreen() + " &b" + Color.LIME.getBlue() + "&7)"));
        inventory.setItem(23, createItemStack(Material.DANDELION_YELLOW, 1, "&6Yellow", "", "&7Click to select Yellow as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.YELLOW.getRed() + " &a" + Color.YELLOW.getGreen() + " &b" + Color.YELLOW.getBlue() + "&7)"));
        inventory.setItem(32, createItemStack(Material.ORANGE_DYE, 1, "&6Orange", "", "&7Click to select Orange as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.ORANGE.getRed() + " &a" + Color.ORANGE.getGreen() + " &b" + Color.ORANGE.getBlue() + "&7)"));
        inventory.setItem(41, createItemStack(Material.ROSE_RED, 1, "&6Red", "", "&7Click to select Red as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.RED.getRed() + " &a" + Color.RED.getGreen() + " &b" + Color.RED.getBlue() + "&7)"));

        //Fourth Column
        inventory.setItem(16, createItemStack(Material.CACTUS_GREEN, 1, "&6Green", "", "&7Click to select Cactus Grren as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.GREEN.getRed() + " &a" + Color.GREEN.getGreen() + " &b" + Color.GREEN.getBlue() + "&7)"));
        inventory.setItem(25, createItemStack(Material.PINK_DYE, 1, "&6Fuchsia", "", "&7Click to select Pink as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.FUCHSIA.getRed() + " &a" + Color.FUCHSIA.getGreen() + " &b" + Color.FUCHSIA.getBlue() + "&7)"));
        inventory.setItem(34, createItemStack(Material.MAGENTA_DYE, 1, "&6Olive", "", "&7Click to select Magenta as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.OLIVE.getRed() + " &a" + Color.OLIVE.getGreen() + " &b" + Color.OLIVE.getBlue() + "&7)"));
        inventory.setItem(43, createItemStack(Material.PURPLE_DYE, 1, "&6Purple", "", "&7Click to select Purple as an " + this.title + " Color",
                "&cR&aG&bB &7(&c" + Color.PURPLE.getRed() + " &a" + Color.PURPLE.getGreen() + " &b" + Color.PURPLE.getBlue() + "&7)"));

        inventory.setItem(48, back());
        inventory.setItem(50, result());

        return inventory;
    }
}
