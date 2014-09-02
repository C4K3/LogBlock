package de.diddiz.util;

import de.diddiz.LogBlock.config.Config;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;

import static de.diddiz.util.TypeColor.DEFAULT;

public class MessagingUtil {
    public static String brackets(String string, BracketType type) {
        return TypeColor.BRACKETS + String.valueOf(type.getStarting()) + string + TypeColor.BRACKETS + type.getEnding() + DEFAULT;
    }

    public static String prettyDate(long date) {
        return TypeColor.DATE + Config.formatter.format(date) + DEFAULT;
    }

    public static String prettyState(String stateName) {
        return TypeColor.STATE + stateName.toUpperCase() + DEFAULT;
    }

    public static String prettyState(int stateValue) {
        return prettyState(Integer.toString(stateValue));
    }

    public static <E extends Enum<E>> String prettyState(E enumerator) {
        return prettyState(enumerator.toString());
    }

    public static String prettyMaterial(String materialName) {
        return TypeColor.MATERIAL + materialName.toUpperCase() + DEFAULT;
    }

    public static String prettyMaterial(Material material) {
        return prettyMaterial(material.name());
    }

    public static String prettyLocation(Location loc) {
        return prettyLocation(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
    }

    public static String prettyLocation(Number x, Number y, Number z) {
        return DEFAULT + "X: " + TypeColor.COORDINATE + x.intValue() + DEFAULT + ", Y: " + TypeColor.COORDINATE + y.intValue() + DEFAULT + ", Z: " + TypeColor.COORDINATE + z.intValue() + DEFAULT;
    }

    public enum BracketType {
        STANDARD('[', ']'),
        ANGLE('<', '>');

        private char starting, ending;

        BracketType(char starting, char ending) {
            this.starting = starting;
            this.ending = ending;
        }

        public char getStarting() {
            return starting;
        }

        public char getEnding() {
            return ending;
        }
    }
}
