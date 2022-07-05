package me.crazydopefox.mcinvbuilder.bukkit.listener;

import me.crazydopefox.mcinvbuilder.bukkit.InventoryDrawHolder;
import me.crazydopefox.mcinvbuilder.bukkit.components.InputZone;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.DragType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;

import java.util.Set;

public class InventoryInputListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        InventoryDrawHolder holder = getHolderFrom(e.getInventory());
        if (holder == null) return;

        Set<InputZone> zones = (Set<InputZone>) holder.getContext(InputZone.CONTEXT_KEY_INPUT_ZONE_LIST);
        if (zones == null) return;

    }

    @EventHandler
    public void onDrag(InventoryDragEvent e) {

    }

    private InventoryDrawHolder getHolderFrom(Inventory inv) {
        return inv.getHolder() instanceof InventoryDrawHolder ? (InventoryDrawHolder) inv.getHolder() : null;
    }

}
