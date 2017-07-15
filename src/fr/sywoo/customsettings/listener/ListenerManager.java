package fr.sywoo.customsettings.listener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import fr.sywoo.customsettings.Main;
import fr.sywoo.customsettings.listener.player.SettingsClick;
import fr.sywoo.customsettings.listener.server.CommandsIntercepter;

public class ListenerManager {

	private Main instance = Main.getInstance();
	
	public void registers() {
		
		PluginManager plugin = Bukkit.getPluginManager();
		
		plugin.registerEvents(new CommandsIntercepter(), instance);
		plugin.registerEvents(new SettingsClick(), instance);
		
	}

}
