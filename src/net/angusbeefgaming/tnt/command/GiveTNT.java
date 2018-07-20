package net.angusbeefgaming.tnt.command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.angusbeefgaming.tnt.api.TNTApi;
import net.md_5.bungee.api.ChatColor;

public class GiveTNT implements CommandExecutor {
	int amount;
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!sender.hasPermission("infinitytnt.givetnt")) {
			sender.sendMessage(ChatColor.RED + "You cannot do this!");
			return false;
		}
		if(args.length < 1) {
			sender.sendMessage(ChatColor.RED + "Usage: /givetnt <Player>");
			return false;
		}
		
		amount = 1;
		
		Player target = Bukkit.getPlayer(args[0]);
		if(target == null) {
			sender.sendMessage(ChatColor.RED + "Player not Found!");
			return false;
		}
		
		// Refrence to the TNT Api
		TNTApi.giveTNT(target);
		
		target.sendMessage(ChatColor.GOLD + "You were given " + amount + " Throwing TNT!");
		
		if(!TNTApi.tntThrowing()) {
			target.sendMessage(ChatColor.RED + "Please note that TNT is currently set to Vanilla mode right now!");
		}
		return true;
	}
	
    private ItemStack nameItem(ItemStack item, String name) {
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(name);
    	item.setItemMeta(meta);
    	return item;
    }

    private ItemStack nameItem(Material item, String name) {
    	return nameItem(new ItemStack(item), name);
    }
}
