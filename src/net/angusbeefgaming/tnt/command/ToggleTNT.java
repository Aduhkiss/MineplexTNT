package net.angusbeefgaming.tnt.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.angusbeefgaming.tnt.api.TNTApi;
import net.md_5.bungee.api.ChatColor;

public class ToggleTNT implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!sender.hasPermission("infinitytnt.switchthrowengine")) {
			sender.sendMessage(ChatColor.RED + "You cannot do this!");
			return false;
		}

		if(TNTApi.tntThrowing()) {
			sender.sendMessage(ChatColor.GREEN + "TNT Throwing Engine Switched to: VANILLA");
			TNTApi.toggleTntThrowing(false);
			return true;
		}
		sender.sendMessage(ChatColor.GREEN + "TNT Throwing Engine Switched to: MINEPLEX");
		TNTApi.toggleTntThrowing(true);
		return true;
	}
}
