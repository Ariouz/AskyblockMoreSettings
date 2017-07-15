package fr.sywoo.customsettings.listener.player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.wasteofplastic.askyblock.ASkyBlockAPI;
import com.wasteofplastic.askyblock.Island.SettingsFlag;

import fr.sywoo.customsettings.player.IslandsSettings;

public class SettingsClick implements Listener {
	 @EventHandler
	    public void onClick(InventoryClickEvent event) {
		 
		 
		 if(event.getClickedInventory() == null) return;
		 
	        if (!event.getInventory().getName().contains("§7Island Settings"))return;

	        Player player = (Player) event.getWhoClicked();

	        IslandsSettings settings = IslandsSettings.getInfos(player);

	        if(!event.getInventory().getName().contains("§7Island Settings")) return;

	        if (ASkyBlockAPI.getInstance().getIslandAt(ASkyBlockAPI.getInstance().getIslandLocation(player.getUniqueId())).inIslandSpace(player.getLocation())) {

	            Material material = event.getCurrentItem().getType();
	            if (event.getClickedInventory() == null) return;
	                event.setCancelled(true);
	                switch (material) {
	                    case MOB_SPAWNER:

	                        settings.setFlag(SettingsFlag.MOB_SPAWN, event.getCurrentItem());
	                        settings.setFlag(SettingsFlag.MONSTER_SPAWN, event.getCurrentItem());

	                        break;
	                    case FENCE_GATE:
	                        settings.setFlag(SettingsFlag.GATE, event.getCurrentItem());


	                        break;
	                    case EGG:

	                        settings.setFlag(SettingsFlag.EGGS, event.getCurrentItem());


	                        break;
	                    case ARMOR_STAND:

	                        settings.setFlag(SettingsFlag.ARMOR_STAND, event.getCurrentItem());


	                        break;
	                    case BED:

	                        settings.setFlag(SettingsFlag.BED, event.getCurrentItem());


	                        break;
	                    case SHEARS:

	                        settings.setFlag(SettingsFlag.SHEARING, event.getCurrentItem());


	                        break;
	                    case FURNACE:

	                        settings.setFlag(SettingsFlag.FURNACE, event.getCurrentItem());


	                        break;
	                    case CARROT_ITEM:

	                        settings.setFlag(SettingsFlag.BREEDING, event.getCurrentItem());


	                        break;
	                    case LEVER:

	                        settings.setFlag(SettingsFlag.REDSTONE, event.getCurrentItem());
	                        settings.setFlag(SettingsFlag.LEVER_BUTTON, event.getCurrentItem());
	                        settings.setFlag(SettingsFlag.PRESSURE_PLATE, event.getCurrentItem());


	                        break;
	                    case DARK_OAK_DOOR_ITEM:

	                        settings.setFlag(SettingsFlag.DOOR, event.getCurrentItem());


	                        break;
	                    case ANVIL:

	                        settings.setFlag(SettingsFlag.ANVIL, event.getCurrentItem());


	                        break;
	                    case ENCHANTMENT_TABLE:

	                        settings.setFlag(SettingsFlag.ENCHANTING, event.getCurrentItem());


	                        break;
	                    case IRON_PICKAXE:

	                        settings.setFlag(SettingsFlag.BREAK_BLOCKS, event.getCurrentItem());


	                        break;
	                    case BEACON:

	                        settings.setFlag(SettingsFlag.BEACON, event.getCurrentItem());


	                        break;
	                    case OBSIDIAN:

	                        settings.setFlag(SettingsFlag.PORTAL, event.getCurrentItem());


	                        break;
	                    case JUKEBOX:

	                        settings.setFlag(SettingsFlag.MUSIC, event.getCurrentItem());


	                        break;
	                    case BREWING_STAND_ITEM:

	                        settings.setFlag(SettingsFlag.BREWING, event.getCurrentItem());


	                        break;
	                    case SLIME_BALL:

	                        settings.setFlag(SettingsFlag.VISITOR_ITEM_DROP, event.getCurrentItem());
	                        player.updateInventory();


	                        break;
	                    case MAGMA_CREAM:

	                        settings.setFlag(SettingsFlag.VISITOR_ITEM_PICKUP, event.getCurrentItem());
	                        player.updateInventory();


	                        break;
	                    case IRON_SWORD:

	                        settings.setFlag(SettingsFlag.HURT_MOBS, event.getCurrentItem());
	                        player.updateInventory();


	                        break;
	                    case DIAMOND_SWORD:

	                        settings.setFlag(SettingsFlag.HURT_MONSTERS, event.getCurrentItem());
	                        player.updateInventory();

	                        break;
	                    case EMERALD:

	                        settings.setFlag(SettingsFlag.VILLAGER_TRADING, event.getCurrentItem());
	                        player.updateInventory();


	                        break;
	                    case ENDER_PEARL:

	                        settings.setFlag(SettingsFlag.ENDER_PEARL, event.getCurrentItem());
	                        player.updateInventory();


	                        break;
	                    case MILK_BUCKET:

	                        settings.setFlag(SettingsFlag.MILKING, event.getCurrentItem());
	                        player.updateInventory();


	                        break;
	                    default:
	                        break;
	                }

	        } else {
	            player.sendMessage("§cVous devez êre sur votre ile !");
	            event.setCancelled(true);
	            player.closeInventory();
	        }
	 }
}
