package de.simagdo.fireworkcreator.system;

import de.simagdo.fireworkcreator.items.FireworkItem;
import de.simagdo.fireworkcreator.listener.GUIListener;
import de.simagdo.fireworkcreator.utils.FireworkCrafter;
import org.bukkit.FireworkEffect;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class FireworkCreator extends JavaPlugin {

    public static String prefix = "§5[§6FireworkCreator§5] §f";
    public static FireworkCrafter crafter = new FireworkCrafter(new ArrayList<>(), new ArrayList<>(), FireworkEffect.Type.BALL, de.simagdo.fireworkcreator.utils.FireworkEffect.GLOWSTONE, 1, 16);

    @Override
    public void onEnable() {
        super.onEnable();

        //Add Recipe
        getServer().addRecipe(new FireworkItem().shapedRecipe());

        //Register Events
        registerEvents(getServer().getPluginManager());

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    private void registerEvents(PluginManager manager) {
        manager.registerEvents(new GUIListener(this), this);
    }

}