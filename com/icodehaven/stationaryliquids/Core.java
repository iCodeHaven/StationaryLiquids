package com.icodehaven.stationaryliquids;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.icodehaven.stationaryliquids.events.LiquidFlow;

public class Core extends JavaPlugin {

	public static Core instance;

	@Override
	public void onEnable() {
		//getCommand("render").setExecutor(new Render(this));
		getConfig().options().copyHeader(true);
		getConfig().options().copyDefaults(true);
		saveConfig();
		instance = this;
		getServer().getPluginManager().registerEvents(new LiquidFlow(), this);
		consoleMessage("&8[&cStationaryLiquids&8] &fThe plugin has been enabled");
	}

	@Override
	public void onDisable() {
		consoleMessage("&8[&cStationaryLiquids&8] &fThe plugin has been disabled");
		instance = null;
	}

	public static Core getInstance() {
		return instance;
	}

	public void consoleMessage(String msg) {
		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}

}