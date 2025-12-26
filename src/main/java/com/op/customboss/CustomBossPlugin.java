package com.op.customboss;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class CustomBossPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Custom Boss Plugin Enabled!");

        new BukkitRunnable() {
            @Override
            public void run() {
                spawnBoss();
            }
        }.runTaskTimer(this, 20L * 60, 20L * 600); // every 10 min
    }

    private void spawnBoss() {
        World world = Bukkit.getWorlds().get(0);
        Random r = new Random();

        int x = r.nextInt(1000) - 500;
        int z = r.nextInt(1000) - 500;
        int y = world.getHighestBlockYAt(x, z) + 1;

        Location loc = new Location(world, x, y, z);

        IronGolem boss = (IronGolem) world.spawnEntity(loc, EntityType.IRON_GOLEM);
        boss.setCustomName("§c§lOP GUARDIAN BOSS");
        boss.setCustomNameVisible(true);
        boss.setHealth(200);
    }
}
