package net.angusbeefgaming.tnt.api;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class TNTApi {
	
	private static boolean tntEnabled;
	private static boolean tntExploding;
	
	/**
	 * Toggle between Vanilla TNT, and Mineplex TNT Exploding
	 * @param a
	 */
	public static void toggleTntExploding(boolean a) {
		tntExploding = a;
	}
	
	/**
	 * Returns if Mineplex Exploding TNT Style is enabled
	 * @return
	 */
	public static boolean tntExploding() {
		return tntExploding;
	}
	
	/**
	 * Toggle between Vanilla TNT, and Mineplex TNT Throwing
	 * @param a
	 */
	public static void toggleTntThrowing(boolean a) {
		tntEnabled = a;
	}
	
	/**
	 * Returns if Mineplex Throwing TNT Style is enabled
	 * @return
	 */
	public static boolean tntThrowing() {
		return tntEnabled;
	}
	
	/***
	 * Give the given player a piece of Throwing TNT
	 * @param pl
	 */
	public static void giveTNT(Player pl) {
		ItemStack tntItem = nameItem(Material.TNT, ChatColor.YELLOW + "Throwable TNT");
		pl.getInventory().addItem(tntItem);
	}
	
    private static ItemStack nameItem(ItemStack item, String name) {
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(name);
    	item.setItemMeta(meta);
    	return item;
    }

    private static ItemStack nameItem(Material item, String name) {
    	return nameItem(new ItemStack(item), name);
    }
}
