package de.simagdo.fireworkcreator.listener;

import de.simagdo.fireworkcreator.GUI.*;
import de.simagdo.fireworkcreator.system.FireworkCreator;
import de.simagdo.fireworkcreator.utils.FireworkCrafter;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.ArrayList;

import static de.simagdo.fireworkcreator.system.FireworkCreator.crafter;

public class GUIListener implements Listener {

    private FireworkCreator plugin;
    private AmountGUI amountGUI = new AmountGUI();

    public GUIListener(FireworkCreator plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onItemInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        //Check if the Item is not null
        if (event.getItem() != null) {
            //Check if Player is holding the correct Item
            if ((event.getItem().getType() == Material.FIREWORK_STAR) && (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eFirework Creator"))) {
                player.openInventory(new MainGUI().openInventory(54, "&6Firework Creator"));
            }
        }

    }

    @EventHandler
    public void onInventoryInteract(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().getName().contains("Firework Creator")) {

            event.setCancelled(true);

            try {
            if (event.getCurrentItem() != null || event.getCurrentItem().getType().equals(Material.AIR)) {
                //Check which Inventory is currently open
                switch (event.getInventory().getName()) {
                    case "§6Firework Creator":

                        //Check which Slot was clicked
                        switch (event.getSlot()) {
                            case 11:
                                player.openInventory(new EffectColorGUI("Effect").openInventory(54, "&6Firework Creator - Effect Color"));
                                break;
                            case 13:
                                player.openInventory(new EffectColorGUI("Fading").openInventory(54, "&6Firework Creator - Fading Color"));
                                break;
                            case 15:
                                player.openInventory(new ShapeGUI().openInventory(54, "&6Firework Creator - Explosion Shape"));
                                break;
                            case 30:
                                //player.openInventory(new EffectGUI().openInventory(36, "&6Firework Creator - Effect"));
                                player.openInventory(amountGUI.openInventory(54, "&6Firework Creator - Amount"));
                                break;
                            case 32:
                                player.openInventory(new ShootPowerGUI().openInventory(36, "&6Firework Creator - Shooting Power"));
                                break;
                            case 49:
                                Bukkit.broadcastMessage(crafter.toString());
                                if ((crafter.getAmount() > 0) && (crafter.getExplosionColors().size() > 0) && (crafter.getFadingColors().size() > 0)) {
                                    player.getInventory().addItem(buildFirework(crafter));
                                }
                                break;
                        }
                        break;
                    case "§6Firework Creator - Effect Color":
                        if (event.getSlot() >= 10 && event.getSlot() <= 43) {
                            crafter.getExplosionColors().add(getColor(event.getCurrentItem()));
                            player.openInventory(new MainGUI().openInventory(54, "&6Firework Creator"));
                        }
                        break;
                    case "§6Firework Creator - Fading Color":
                        if (event.getSlot() >= 10 && event.getSlot() <= 43) {
                            crafter.getFadingColors().add(getColor(event.getCurrentItem()));
                            player.openInventory(new MainGUI().openInventory(54, "&6Firework Creator"));
                        }
                        break;
                    case "§6Firework Creator - Explosion Shape":
                        switch (event.getSlot()) {
                            case 11:
                                crafter.setExplosionShape(FireworkEffect.Type.BALL);
                                break;
                            case 13:
                                crafter.setExplosionShape(FireworkEffect.Type.BALL_LARGE);
                                break;
                            case 15:
                                crafter.setExplosionShape(FireworkEffect.Type.STAR);
                                break;
                            case 30:
                                crafter.setExplosionShape(FireworkEffect.Type.CREEPER);
                                break;
                            case 32:
                                crafter.setExplosionShape(FireworkEffect.Type.BURST);
                                break;
                        }
                        player.openInventory(new MainGUI().openInventory(54, "&6Firework Creator"));
                        //case "§6Firework Creator - Effect":
                    case "§6Firework Creator - Amount":
                        switch (event.getSlot()) {
                            case 11:
                                crafter.setAmount(16);
                                break;
                            case 13:
                                crafter.setAmount(32);
                                break;
                            case 15:
                                crafter.setAmount(48);
                                break;
                            case 30:
                                crafter.setAmount(64);
                                break;
                            case 32:
                                if (event.isLeftClick() && event.isShiftClick()) {
                                    crafter.setAmount(crafter.getAmount() + 16);
                                } else if (event.isLeftClick()) {
                                    crafter.setAmount(crafter.getAmount() + 1);
                                } else if ((event.isRightClick() && event.isShiftClick()) && ((crafter.getAmount() - 16) > 0)) {
                                    crafter.setAmount(crafter.getAmount() - 16);
                                } else if ((event.isRightClick()) && ((crafter.getAmount() - 1) > 0)) {
                                    crafter.setAmount(crafter.getAmount() - 1);
                                }
                                break;
                        }
                        player.openInventory(amountGUI.openInventory(54, "&6Firework Creator - Amount"));
                        break;
                    case "§6Firework Creator - Shooting Power":
                        crafter.setShootingPower(event.getSlot() == 11 ? 1 : event.getSlot() == 13 ? 2 : 3);
                        player.openInventory(new MainGUI().openInventory(54, "&6Firework Creator"));
                        break;
                }

                //Open the previous Inventory
                if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§bBack") /*&& (event.getCurrentItem() != null || event.getCurrentItem().getType() != Material.AIR)*/) {
                    player.openInventory(new MainGUI().openInventory(54, "&6Firework Creator"));
                }
            }
            } catch (NullPointerException ignored) {

            }
        }
    }

    /**
     * Get the Color based on the {@link ItemStack}
     *
     * @param itemStack which is used to get the {@link DyeColor}
     * @return the {@link DyeColor}
     */
    private DyeColor getColor(ItemStack itemStack) {
        String name = itemStack.getItemMeta().getDisplayName().replace("§6", "");

        switch (name) {
            case "White":
                return DyeColor.WHITE;
            case "Silver":
                return DyeColor.LIGHT_GRAY;
            case "Gray":
                return DyeColor.GRAY;
            case "Black":
                return DyeColor.BLACK;
            case "Teal":
                return DyeColor.LIGHT_BLUE;
            case "Navy":
                return DyeColor.BLUE;
            case "Blue":
                return DyeColor.BLUE;
            case "Maroon":
                return DyeColor.BROWN;
            case "Lime":
                return DyeColor.LIME;
            case "Yellow":
                return DyeColor.YELLOW;
            case "Orange":
                return DyeColor.ORANGE;
            case "Red":
                return DyeColor.RED;
            case "Green":
                return DyeColor.GREEN;
            case "Fuchsia":
                return DyeColor.PINK;
            case "Olive":
                return DyeColor.MAGENTA;
            case "Purple":
                return DyeColor.PURPLE;
        }

        return null;
    }

    /**
     * Build the Firework based on the {@link FireworkCrafter}
     *
     * @param crafter which will be used to build the Firework
     * @return
     */
    private ItemStack buildFirework(FireworkCrafter crafter) {
        ItemStack firework = new ItemStack(Material.FIREWORK_ROCKET, crafter.getAmount());
        FireworkMeta meta = (FireworkMeta) firework.getItemMeta();
        final FireworkEffect effect;

        //Set Power
        meta.setPower(crafter.getShootingPower());

        //Add Effects
        effect = FireworkEffect.builder().withColor(changeColor(crafter.getExplosionColors())).withFade(changeColor(crafter.getFadingColors())).with(crafter.getExplosionShape()).withTrail().build();

        //Add the Effect to the FireworkMeta
        meta.addEffect(effect);

        //Set the ItemMeta for the ItemStack
        firework.setItemMeta(meta);

        return firework;
    }

    /**
     * Change the DyeColor to the Firework Color so it can be used for the {@link FireworkEffect}
     *
     * @param dyeColors which will be changed
     * @return the original Color based on the {@link DyeColor}
     */
    private ArrayList<Color> changeColor(ArrayList<DyeColor> dyeColors) {
        ArrayList<Color> colors = new ArrayList<>();
        dyeColors.forEach(dyeColor -> colors.add(dyeColor.getFireworkColor()));
        return colors;
    }

}
