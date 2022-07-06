package me.crazydopefox.mcinvbuilder.bukkit.listener;

import me.crazydopefox.mcinvbuilder.bukkit.InventoryDrawHolder;
import me.crazydopefox.mcinvbuilder.bukkit.components.InputZone;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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

        switch (e.getAction()) {
            case PICKUP_ALL:
            case PICKUP_HALF:
            case PICKUP_ONE:
            case PICKUP_SOME:
            case PLACE_ALL:
            case PLACE_ONE:
            case PLACE_SOME:
            case SWAP_WITH_CURSOR:
            case COLLECT_TO_CURSOR:
                //TODO: update InputSlot's item
                break;
            case MOVE_TO_OTHER_INVENTORY:
                //TODO: add item to InputZone
                break;
            default: break;
        }
    }

    @EventHandler
    public void onDrag(InventoryDragEvent e) {
        
    }

    private InventoryDrawHolder getHolderFrom(Inventory inv) {
        return inv.getHolder() instanceof InventoryDrawHolder ? (InventoryDrawHolder) inv.getHolder() : null;
    }

}
