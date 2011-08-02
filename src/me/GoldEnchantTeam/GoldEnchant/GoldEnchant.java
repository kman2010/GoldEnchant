package me.GoldEnchantTeam.GoldEnchant;

import java.util.logging.Logger;
import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GoldEnchant extends JavaPlugin {
	private final GoldEnchantPlayerListener playerListener = new GoldEnchantPlayerListener(
			this);
	private final GoldEnchantEntityListener entityListener = new GoldEnchantEntityListener(
			this);
	public static Logger log = Logger.getLogger("Minecraft");
	public static Server server;
	String logPrefix = "[GoldEnchant] ";

	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener,
				Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_DAMAGE, entityListener,
				Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener,
				Event.Priority.Normal, this);
		log.info(logPrefix + "1.0 has been enabled");
	}

	public void onDisable() {
		log.info(logPrefix + "1.0 has been disabled");
	}
}