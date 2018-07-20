package net.angusbeefgaming.tnt;

import org.bukkit.plugin.java.JavaPlugin;

import net.angusbeefgaming.tnt.api.TNTApi;
import net.angusbeefgaming.tnt.command.GiveTNT;
import net.angusbeefgaming.tnt.command.TNTExplodingEngine;
import net.angusbeefgaming.tnt.command.ToggleTNT;
import net.angusbeefgaming.tnt.listener.ExplodeListener;
import net.angusbeefgaming.tnt.listener.ThrowTNT;

public class TNT extends JavaPlugin {

	@Override
	public void onEnable() {
		TNTApi.toggleTntThrowing(true);
		TNTApi.toggleTntExploding(true);
		
		getServer().getPluginManager().registerEvents(new ExplodeListener(), this);
		getServer().getPluginManager().registerEvents(new ThrowTNT(), this);
		
		getCommand("givetnt").setExecutor(new GiveTNT());
		getCommand("switchthrowengine").setExecutor(new ToggleTNT());
		getCommand("switchexplodeengine").setExecutor(new TNTExplodingEngine());
	}
	
}
