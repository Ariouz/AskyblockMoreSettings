package fr.sywoo.customsettings.player;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.wasteofplastic.askyblock.ASkyBlockAPI;
import com.wasteofplastic.askyblock.Island;
import com.wasteofplastic.askyblock.Island.SettingsFlag;

public class IslandsSettings {
	
	private static HashMap<Player, IslandsSettings> settings = new HashMap<>();
	private ArrayList<ItemStack> items = new ArrayList<>();
	private Island island;
	private Player player;
	
	private String allowed = "§aAutorisé";
	private String denied = "§cInterdit";
	
	public IslandsSettings(Location location, Player player) {

		this.island = ASkyBlockAPI.getInstance().getIslandAt(location);
		this.player = player;
		settings.put(player, this);
		loadItems();
	}
	
	private ItemStack makeItem(Material material, String name, Boolean allow){

		List<String> isAllowed = new ArrayList<>();
		isAllowed.add(allowed);
		List<String> isDenied = new ArrayList<>();
		isDenied.add(denied);
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		if(allow){
			meta.setLore(isAllowed);
		}else{
			meta.setLore(isDenied);
		}
		item.setItemMeta(meta);
		
		return item;
	}
	
	private void loadItems(){
		
        boolean portique = island.getIgsFlag(SettingsFlag.GATE);
        boolean egg = island.getIgsFlag(SettingsFlag.EGGS);
        boolean armorstand = island.getIgsFlag(SettingsFlag.ARMOR_STAND);
        boolean bed = island.getIgsFlag(SettingsFlag.BED);
        boolean shear = island.getIgsFlag(SettingsFlag.SHEARING);
        boolean furnace = island.getIgsFlag(SettingsFlag.FURNACE);
        boolean reproduction = island.getIgsFlag(SettingsFlag.BREEDING);
        boolean redstone = island.getIgsFlag(SettingsFlag.REDSTONE);
        boolean door = island.getIgsFlag(SettingsFlag.DOOR);
        boolean anvil = island.getIgsFlag(SettingsFlag.ANVIL);
        boolean enchanter = island.getIgsFlag(SettingsFlag.ENCHANTING);
        boolean breakblock = island.getIgsFlag(SettingsFlag.BREAK_BLOCKS);
        boolean beacon = island.getIgsFlag(SettingsFlag.BEACON);
        boolean portal = island.getIgsFlag(SettingsFlag.PORTAL);
        boolean jukebox = island.getIgsFlag(SettingsFlag.MUSIC);
        boolean potions = island.getIgsFlag(SettingsFlag.BREWING);
        boolean spawnmob = island.getIgsFlag(SettingsFlag.MONSTER_SPAWN);
        boolean dropitems = island.getIgsFlag(SettingsFlag.VISITOR_ITEM_DROP);
        boolean pickupitem = island.getIgsFlag(SettingsFlag.VISITOR_ITEM_PICKUP);
        boolean hitmob = island.getIgsFlag(SettingsFlag.HURT_MOBS);
        boolean hitmonsters = island.getIgsFlag(SettingsFlag.HURT_MONSTERS);
        boolean trading = island.getIgsFlag(SettingsFlag.VILLAGER_TRADING);
        boolean enderpearl = island.getIgsFlag(SettingsFlag.ENDER_PEARL);
        boolean makemilk = island.getIgsFlag(SettingsFlag.MILKING);

        items.add(makeItem(Material.FENCE_GATE, "§7Accès portiques", portique));
        items.add(makeItem(Material.EGG, "§7Casser des oeufs", egg));
        items.add(makeItem(Material.ARMOR_STAND, "§7Acces Stand Armor", armorstand));
        items.add(makeItem(Material.BED, "§7Occupez votre lit", bed));
        items.add(makeItem(Material.SHEARS, "§7Tondre vos moutons", shear));
        items.add(makeItem(Material.FURNACE, "§7Utiliser vos fours", furnace));
        items.add(makeItem(Material.CARROT_ITEM, "§7Nourrir vos animaux", reproduction));
        items.add(makeItem(Material.LEVER, "§7Manipulez votre RedStone", redstone));
        items.add(makeItem(Material.DARK_OAK_DOOR_ITEM, "§7Ouvir vos portes", door));
        items.add(makeItem(Material.ANVIL, "§7Forger chez vous", anvil));
        items.add(makeItem(Material.ENCHANTMENT_TABLE, "§7Enchanter chez vous", enchanter));
        items.add(makeItem(Material.IRON_PICKAXE, "§7Cassez chez vous", breakblock));
        items.add(makeItem(Material.BEACON, "§7Modifier vos beacons", beacon));
        items.add(makeItem(Material.OBSIDIAN, "§7Utiliser votre portail", portal));
        items.add(makeItem(Material.JUKEBOX, "§7Changer votre musique", jukebox));
        items.add(makeItem(Material.BREWING_STAND_ITEM, "§7Boir vos potions", potions));
        items.add(makeItem(Material.MOB_SPAWNER, "§7Spawn de Mob", spawnmob));
        items.add(makeItem(Material.SLIME_BALL, "§7Les visiteurs peuvent drop des items", dropitems));
        items.add(makeItem(Material.MAGMA_CREAM, "§7Les visiteurs peuvent récuprer des items", pickupitem));
        items.add(makeItem(Material.IRON_SWORD, "§7Tappez vos animaux", hitmob));
        items.add(makeItem(Material.DIAMOND_SWORD, "§7Tappez vos monstres", hitmonsters));
        items.add(makeItem(Material.EMERALD, "§7Commercez avec vos PNJ", trading));
        items.add(makeItem(Material.ENDER_PEARL, "§7Se téléporter", enderpearl));
        items.add(makeItem(Material.MILK_BUCKET, "§7Se servir un verre de lait", makemilk));

    }

	private ItemStack Infos(){
		
		  Timestamp stamp = new Timestamp(island.getCreatedDate());
		  Date date = new Date(stamp.getTime());

		List<String> lores = new ArrayList<>();
		lores.add("Ile cr§e le: " + date);
		for(Player player : Bukkit.getOnlinePlayers()){
			if(island.getMembers().contains(player.getUniqueId())){
				lores.add("- §7" + player.getDisplayName());
			}
		}
		
		ItemStack item = new ItemStack(Material.PAPER);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§bParamètre d'ile");

		meta.setLore(lores);
		item.setItemMeta(meta);
		
		return item;
		
	}
	
	public Inventory inventory(){
		items.clear();
		loadItems();
		Inventory inventory = Bukkit.createInventory(player, 27, "§7Island Settings");
		inventory.setItem(0, Infos());
		for (int i = 0; i < items.size(); i++) {
			inventory.setItem(i+1, items.get(i));
		}
		
		return inventory;
	}
	
	public void setFlag(SettingsFlag flag, ItemStack item){
	
		List<String> isAllowed = new ArrayList<>();
		isAllowed.add(allowed);
		List<String> isDenied = new ArrayList<>();
		isDenied.add(denied);
		
		if(item.getItemMeta().getLore().contains(allowed)){
			
			island.setIgsFlag(flag, false);
			item.getItemMeta().setLore(isDenied);
			
		}else if(item.getItemMeta().getLore().contains(denied)){
			
			island.setIgsFlag(flag, true);
			item.getItemMeta().setLore(isAllowed);

		}
		
		player.sendMessage("§3[Paramétre d'ile] §aVous venez de changer un paramètre de visite");
		player.openInventory(inventory());
		
	}

	
	
	public static IslandsSettings getInfos(Player player){
		
		if(settings.containsKey(player)){
			return settings.get(player);
		}else{
			return new IslandsSettings(player.getLocation(), player);
		}
		
	}
	

}
