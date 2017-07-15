package fr.sywoo.customsettings.listener.server;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.wasteofplastic.askyblock.ASkyBlockAPI;

import fr.sywoo.customsettings.player.IslandsSettings;

public class CommandsIntercepter implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event){
		
		Player player = event.getPlayer();
		String command = event.getMessage();
		
		if(command.contains("/akyblock:settings")){
			event.setCancelled(true);
			return;
		}
		
		if(command.contains("/island settings") || command.contains("/is settings")){
			event.setCancelled(true);
			if(ASkyBlockAPI.getInstance().getIslandAt(player.getLocation()) == null){
				player.sendMessage("§cVeuillez faire ca sur votre Ile !");
				return;
			}
			if(!ASkyBlockAPI.getInstance().hasIsland(player.getUniqueId())){
				player.sendMessage("§cVous n'êtes propriétaire d'aucune ile !");
				return;
			}
			if(ASkyBlockAPI.getInstance().getIslandAt(player.getLocation()).getMembers().contains(player.getUniqueId())){
				player.openInventory(IslandsSettings.getInfos(player).inventory());
			}else{
				player.sendMessage("§cVous devez être sur votre ile !");
				return;
			}
			
		}
		
		
		
	}

}
