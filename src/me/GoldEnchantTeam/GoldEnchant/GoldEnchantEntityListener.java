package me.GoldEnchantTeam.GoldEnchant;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityListener;

public class GoldEnchantEntityListener extends EntityListener {
	public static GoldEnchant plugin;

	public GoldEnchantEntityListener(GoldEnchant instance) {
		plugin = instance;
	}

	@Override
	public void onEntityDamage(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player))
			return;
		final Player eventPlayer = (Player) event.getEntity();
		if (Material.CHAINMAIL_BOOTS.equals(eventPlayer.getInventory()
				.getBoots().getType())
				&& event.getCause().equals(DamageCause.FALL)
				&& eventPlayer.hasPermission("goldEnchant.boots")) {
			event.setCancelled(true);
		}
		if (eventPlayer.getInventory().getHelmet().getType()
				.equals(Material.CHAINMAIL_HELMET)
				&& event.getCause().equals(DamageCause.DROWNING)
				&& eventPlayer.hasPermission("goldEnchant.helmet")) {
			event.setCancelled(true);
		}
		if (Material.CHAINMAIL_CHESTPLATE.equals(eventPlayer.getInventory()
				.getChestplate().getType())
				&& event.getCause().equals(DamageCause.FIRE_TICK)
				&& eventPlayer.hasPermission("goldEnchant.chestplate")) {
			event.setCancelled(true);
		}
		if (Material.CHAINMAIL_CHESTPLATE.equals(eventPlayer.getInventory()
				.getChestplate().getType())
				&& event.getCause().equals(DamageCause.LAVA)
				&& eventPlayer.hasPermission("goldEnchant.chestplate")) {
			event.setCancelled(true);
		}
	}
}