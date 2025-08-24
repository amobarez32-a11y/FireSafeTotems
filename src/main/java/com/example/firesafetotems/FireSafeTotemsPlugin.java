package com.example.firesafetotems;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class FireSafeTotemsPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("FireSafeTotems enabled — Totems will no longer burn!");
    }

    @EventHandler
    public void onItemCombust(EntityCombustEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Item droppedItem) {
            if (droppedItem.getItemStack().getType() == Material.TOTEM_OF_UNDYING) {
                event.setCancelled(true);
            }
        }
    }
}
