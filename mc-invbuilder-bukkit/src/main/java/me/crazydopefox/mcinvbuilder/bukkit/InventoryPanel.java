package me.crazydopefox.mcinvbuilder.bukkit;

import lombok.Getter;
import me.crazydopefox.mcinvbuilder.core.draw.DrawSession;
import me.crazydopefox.mcinvbuilder.core.draw.IDrawPanel;
import org.bukkit.inventory.ItemStack;

public class InventoryPanel extends IDrawPanel<ItemStack> {

    @Getter private final int height, width;

    public InventoryPanel(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public DrawSession<ItemStack> startDrawSession() {
        return null;
    }

}
