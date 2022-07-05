package me.crazydopefox.mcinvbuilder.bukkit;

import me.crazydopefox.mcinvbuilder.core.draw.AbstractDrawFactory;
import me.crazydopefox.mcinvbuilder.core.draw.IDrawPanel;
import org.bukkit.inventory.ItemStack;

public class BukkitDrawFactory extends AbstractDrawFactory<ItemStack> {

    @Override
    public IDrawPanel<ItemStack> createDrawPanel(int height, int width) {
        return new InventoryPanel(height, width);
    }

}
