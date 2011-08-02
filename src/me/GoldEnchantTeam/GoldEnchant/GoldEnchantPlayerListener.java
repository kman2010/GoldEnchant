package me.GoldEnchantTeam.GoldEnchant;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class GoldEnchantPlayerListener extends PlayerListener {
	public GoldEnchantPlayerListener(GoldEnchant goldEnchant) {
		// TODO Auto-generated constructor stub
	}

	public void onPlayerMove(PlayerMoveEvent event) {
		final Player eventPlayer = (Player) event.getPlayer();
		if (event.getPlayer().isSneaking()
				&& event.getPlayer().getInventory().getLeggings().getType()
						.equals(Material.CHAINMAIL_LEGGINGS)
				&& eventPlayer.hasPermission("goldEnchant.leggings")) {
			Vector maximumVector = event.getTo().toVector()
					.subtract(event.getFrom().toVector()).normalize()
					.multiply(3);
			Double maximumlength = maximumVector.length();
			Double currentlength = event.getPlayer().getVelocity().length();
			if (currentlength > maximumlength) {
				event.getPlayer().setVelocity(maximumVector);
				return;
			}
			Vector dir = event.getPlayer().getLocation().getDirection()
					.multiply(3);
			event.getPlayer().setVelocity(dir);
		}
	}

	public void onPlayerInteract(PlayerInteractEvent event) {
		final Player eventPlayer = (Player) event.getPlayer();
		if (event.getClickedBlock().getType() == Material.DIAMOND_BLOCK
				&& eventPlayer.hasPermission("goldEnchant.enchant")) {
			ItemStack item = event.getItem();
			short d = item.getDurability();
			Player p = event.getPlayer();
			switch (item.getType()) {
			case GOLD_HELMET:
				item.setType(Material.CHAINMAIL_HELMET);
				item.setDurability(d);
				p.sendMessage("[GoldEnchant] Helmet enchanted! You can breate underwater!");
				break;
			case GOLD_CHESTPLATE:
				item.setType(Material.CHAINMAIL_CHESTPLATE);
				item.setDurability(d);
				p.sendMessage("[GoldEnchant] Chestplate enchanted! You can go all out god-mode");
				break;
			case GOLD_LEGGINGS:
				item.setType(Material.CHAINMAIL_LEGGINGS);
				item.setDurability(d);
				p.sendMessage("[GoldEnchant] Leggings enchanted! You can go really fast!");
				break;
			case GOLD_BOOTS:
				item.setType(Material.CHAINMAIL_BOOTS);
				item.setDurability(d);
				p.sendMessage("[GoldEnchant] Boots enchanted! You can fall from the moon!");
				break;
			}
		}
	}
}