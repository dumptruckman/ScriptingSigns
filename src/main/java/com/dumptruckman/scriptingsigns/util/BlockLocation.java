package com.dumptruckman.scriptingsigns.util;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;

public class BlockLocation {
    
    private final String worldName;
    private final int x;
    private final int y;
    private final int z;

    private BlockLocation(Block block) {
        this(block.getWorld(), block.getX(), block.getY(), block.getZ());
    }

    private BlockLocation(World world, int x, int y, int z) {
        this(world.getName(), x, y, z);
    }

    private BlockLocation(String worldName, int x, int y, int z) {
        this.worldName = worldName;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public final String getWorldName() {
        return worldName;
    }
    
    public final World getWorld() {
        return Bukkit.getWorld(this.worldName);
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final int getZ() {
        return z;
    }

    @Override
    public final String toString() {
        return this.worldName + this.x + this.y + this.z;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BlockLocation) {
            BlockLocation otherLoc = (BlockLocation) o;
            if (this.getWorldName().equals(otherLoc.getWorldName())
                    && this.getX() == otherLoc.getX()
                    && this.getY() == otherLoc.getY()
                    && this.getZ() == otherLoc.getZ())  {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
    
    public static BlockLocation get(Block block) {
        return new BlockLocation(block);
    }
}
