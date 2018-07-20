package net.angusbeefgaming.tnt.listener;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import net.angusbeefgaming.tnt.api.TNTApi;
import net.md_5.bungee.api.ChatColor;

public class ThrowTNT implements Listener {
    @SuppressWarnings({ "unchecked", "deprecation" })
	@EventHandler
    public void onInteract(final PlayerInteractEvent event) {
    	
    	if(!TNTApi.tntThrowing()) {
    		return;
    	}
        final Player player = event.getPlayer();
        final World world = player.getWorld();
        final ItemStack item = player.getInventory().getItemInHand();
        if(item.getType() == Material.TNT) {
            if(item.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Throwable TNT")) {
                event.setCancelled(true);
                if (item.getAmount() == 1) {
                    player.getInventory().remove(item);
                }
                else {
                    item.setAmount(item.getAmount() - 1);
                }
                @SuppressWarnings("rawtypes")
				final TNTPrimed tnt = (TNTPrimed)world.spawn(player.getLocation(), (Class)TNTPrimed.class);
                final Vector playerDirection = player.getLocation().getDirection();
                final Vector smallerVector = playerDirection.multiply(TNTApi.getPower());
                tnt.setVelocity(smallerVector);
            }
        }
    }
}
