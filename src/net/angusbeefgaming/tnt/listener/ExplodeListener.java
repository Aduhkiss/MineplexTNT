package net.angusbeefgaming.tnt.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.util.Vector;

import net.angusbeefgaming.tnt.api.TNTApi;

public class ExplodeListener implements Listener {
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event)
    
    {
        if(!TNTApi.tntExploding()) {
        	return;
        }
        
    	for(Block b : event.blockList()) { 
    		float x = (float) -2 + (float) (Math.random() * ((2 - -2) + 1));
    		float y = (float) -2 + (float) (Math.random() * ((4 - -4) + 1));
    		float z = (float) -2 + (float) (Math.random() * ((2 - -2) + 1));
    		
    		@SuppressWarnings("deprecation")
			FallingBlock fallingBlock = b.getWorld().spawnFallingBlock(b.getLocation(),  b.getType(), b.getData());
    		fallingBlock.setDropItem(false);
    		fallingBlock.setVelocity(new Vector(x/3, y/3, z/3));
    		
    		b.setType(Material.AIR);
    	}
    }
}
