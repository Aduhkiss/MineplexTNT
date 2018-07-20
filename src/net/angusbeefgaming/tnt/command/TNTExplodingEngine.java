package net.angusbeefgaming.tnt.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.angusbeefgaming.tnt.api.TNTApi;
import net.md_5.bungee.api.ChatColor;

public class TNTExplodingEngine implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!sender.hasPermission("infinitytnt.switchexplodeengine")) {
			sender.sendMessage(ChatColor.RED + "You cannot do this!");
			return false;
		}

		if(TNTApi.tntThrowing()) {
			sender.sendMessage(ChatColor.GREEN + "TNT Exploding Engine Switched to: VANILLA");
			TNTApi.toggleTntExploding(false);
			return true;
		}
		sender.sendMessage(ChatColor.GREEN + "TNT Exploding Engine Switched to: MINEPLEX");
		TNTApi.toggleTntExploding(true);
		return true;
	}
}
