package de.simagdo.fireworkcreator.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FireworkItem {

    public ShapedRecipe shapedRecipe() {
        ItemStack itemStack = new ItemStack(Material.FIREWORK_STAR);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§eFirework Creator");

        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7Create custom Fireworks with this tool");

        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        ShapedRecipe recipe = new ShapedRecipe(itemStack);
        recipe.shape("G G", " P ", "G G");
        recipe.setIngredient('G', Material.GUNPOWDER);
        recipe.setIngredient('P', Material.PAPER);

        return recipe;
    }

}
