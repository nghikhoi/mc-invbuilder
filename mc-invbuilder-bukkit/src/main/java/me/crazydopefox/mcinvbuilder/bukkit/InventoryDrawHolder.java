package me.crazydopefox.mcinvbuilder.bukkit;

import me.crazydopefox.mcinvbuilder.core.draw.DrawHolder;
import me.crazydopefox.mcinvbuilder.core.draw.IDrawPanel;
import me.crazydopefox.mcinvbuilder.core.draw.IWidget;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class InventoryDrawHolder extends DrawHolder<ItemStack> implements InventoryHolder {

    public InventoryDrawHolder(IWidget<ItemStack> drawable, IDrawPanel<ItemStack> drawPanel) {
        super(drawable, drawPanel);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return null;
    }

}
