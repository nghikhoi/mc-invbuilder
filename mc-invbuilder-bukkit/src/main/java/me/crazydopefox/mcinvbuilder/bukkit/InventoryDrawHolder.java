package me.crazydopefox.mcinvbuilder.bukkit;

import me.crazydopefox.mcinvbuilder.core.draw.DrawHolder;
import me.crazydopefox.mcinvbuilder.core.draw.IDrawPanel;
import me.crazydopefox.mcinvbuilder.core.draw.IWidget;
import org.bukkit.inventory.ItemStack;

public class InventoryDrawHolder extends DrawHolder<ItemStack>  {

    public InventoryDrawHolder(IWidget<ItemStack> drawable, IDrawPanel<ItemStack> drawPanel) {
        super(drawable, drawPanel);
    }

    @Override
    public IDrawPanel<ItemStack> getDrawPanel() {
        return null;
    }

}
