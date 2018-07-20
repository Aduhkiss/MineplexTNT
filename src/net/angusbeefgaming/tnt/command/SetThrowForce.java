package net.angusbeefgaming.tnt.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.angusbeefgaming.tnt.api.TNTApi;
import net.md_5.bungee.api.ChatColor;

public class SetThrowForce implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!sender.hasPermission("infinitytnt.setforce")) {
			sender.sendMessage(ChatColor.RED + "You cannot do this!");
			return false;
		}
		if(args.length < 1) {
			sender.sendMessage(ChatColor.RED + "Usage: /setforce <Force Amount>");
			return false;
		}
		double force = Double.valueOf(args[0]);
		
		TNTApi.setPower(force);
		sender.sendMessage(ChatColor.GOLD + "Set TNT Throw Force to " + force);
		return true;
	}
}
