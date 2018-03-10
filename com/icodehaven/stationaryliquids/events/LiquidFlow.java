package com.icodehaven.stationaryliquids.events;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

import com.icodehaven.stationaryliquids.Core;

public class LiquidFlow implements Listener {
	
	List<String> materials = Core.getInstance().getConfig().getStringList("blocks");

	@EventHandler
	public void onPlayerBucketEmpty(BlockFromToEvent  event) {
		if (event.isCancelled() || !event.getBlock().isLiquid()) {
			return;
		}
		World world = event.getBlock().getWorld();
		int x = event.getBlock().getX();
		int y = event.getBlock().getY();
		int z = event.getBlock().getZ();
		Location loc = new Location(world, x, y, z);
		Block b1 = loc.getBlock().getRelative(BlockFace.NORTH);
		Block b2 = loc.getBlock().getRelative(BlockFace.EAST);
		Block b3 = loc.getBlock().getRelative(BlockFace.SOUTH);
		Block b4 = loc.getBlock().getRelative(BlockFace.WEST);
		Material blockOneType = b1.getType();
		Material blockTwoType = b2.getType();
		Material blockThreeType = b3.getType();
		Material blockFourType = b4.getType();
		if (materials.contains(String.valueOf(blockOneType)) || materials.contains(String.valueOf(blockTwoType)) || materials.contains(String.valueOf(blockThreeType)) || materials.contains(String.valueOf(blockFourType))) {
			event.setCancelled(true);
		}

	}

}
