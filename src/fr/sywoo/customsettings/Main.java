package fr.sywoo.customsettings;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.sywoo.customsettings.listener.ListenerManager;

public class Main extends JavaPlugin{
	
	private static Main instance;

	@Override
	public void onEnable() {

		instance = this;
		
		new ListenerManager().registers();
		Bukkit.getConsoleSender().sendMessage("§aMore Settings For AskyBlock was enable");
		
		
	}
	
	@Override
	public void onDisable() {

		
		
	}
	
	
	
	public static Main getInstance() {
		return instance;
	}
}
