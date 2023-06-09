package it.technoade.technoblocks.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.List;

public class Utils {

    public static ItemStack createItem(int quantity, short dmg, String title, Material material, List<ItemFlag> itemFlags, List<String> lore, List<Enchantment> enchantments) {
        ItemStack item = new ItemStack(material, quantity, dmg);
        ItemMeta meta = item.getItemMeta();
        if(title != null) {
            meta.setDisplayName(title);
        }
        if(!enchantments.isEmpty()) {
            enchantments.forEach(enchantment -> item.addEnchantment(enchantment, 1));
        }
        if(!itemFlags.isEmpty()) {
            itemFlags.forEach(meta != null ? meta::addItemFlags : null);
        }
        if(!lore.isEmpty()) {
            if (meta != null) {
                meta.setLore(lore);
            }
        }
        item.setItemMeta(meta);
        return item;
    }

    public static String color(String msg) {
        return msg.replaceAll("&", "§");
    }

}
