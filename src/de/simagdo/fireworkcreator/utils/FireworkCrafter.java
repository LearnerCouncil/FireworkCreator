package de.simagdo.fireworkcreator.utils;

import org.bukkit.DyeColor;
import org.bukkit.FireworkEffect.Type;

import java.util.ArrayList;

public class FireworkCrafter {

    private ArrayList<DyeColor> explosionColors;
    private ArrayList<DyeColor> fadingColors;
    private Type explosionShape;
    private FireworkEffect effect;
    private int shootingPower;
    private int amount;

    public FireworkCrafter(ArrayList<DyeColor> explosionColors, ArrayList<DyeColor> fadingColors, org.bukkit.FireworkEffect.Type explosionShape, FireworkEffect effect, int shootingPower, int amount) {
        this.explosionColors = explosionColors;
        this.fadingColors = fadingColors;
        this.explosionShape = explosionShape;
        this.effect = effect;
        this.shootingPower = shootingPower;
        this.amount = amount;
    }

    public ArrayList<DyeColor> getExplosionColors() {
        return explosionColors;
    }

    public void setExplosionColors(ArrayList<DyeColor> explosionColors) {
        this.explosionColors = explosionColors;
    }

    public ArrayList<DyeColor> getFadingColors() {
        return fadingColors;
    }

    public void setFadingColors(ArrayList<DyeColor> fadingColors) {
        this.fadingColors = fadingColors;
    }

    public org.bukkit.FireworkEffect.Type getExplosionShape() {
        return explosionShape;
    }

    public void setExplosionShape(Type explosionShape) {
        this.explosionShape = explosionShape;
    }

    public FireworkEffect getEffect() {
        return effect;
    }

    public void setEffect(FireworkEffect effect) {
        this.effect = effect;
    }

    public int getShootingPower() {
        return shootingPower;
    }

    public void setShootingPower(int shootingPower) {
        this.shootingPower = shootingPower;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String toString() {
        return "ExplosionColors: " + explosionColors + ", FadingColors: " + fadingColors + ", Type: " + explosionShape.name() + ", Effect: " + effect.name() + ", ShootingPower: " + shootingPower + ", Amount: " + amount;
    }

}
