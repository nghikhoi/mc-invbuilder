package me.crazydopefox.mcinvbuilder.bukkit;

import lombok.Getter;
import lombok.Setter;
import me.crazydopefox.mcinvbuilder.core.draw.DrawSession;
import me.crazydopefox.mcinvbuilder.core.draw.IDrawPanel;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class InventoryPanel extends IDrawPanel<ItemStack> {

    @Getter private final int height, width;
    @Getter @Setter
    private String title;
    @Getter @Setter private InventoryHolder holder;
    @Getter(lazy = true) private final Inventory inventory = Bukkit.createInventory(holder, height * width, title);

    public InventoryPanel(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public DrawSession<ItemStack> startDrawSession() {
        return null;
    }

}
