package me.crazydopefox.mcinvbuilder.bukkit.components;

import lombok.Getter;
import me.crazydopefox.mcinvbuilder.bukkit.components.events.ItemUpdateEvent;
import me.crazydopefox.mcinvbuilder.core.draw.Widget;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class InputSlot extends Widget<ItemStack> {

    @Getter
    private ItemStack item;

    public void setItem(ItemStack item) {
        if (Objects.equals(this.item, item)) {
            return;
        }
        this.item = item;
        notifyEvent(new ItemUpdateEvent(this));
    }

    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public int getWidth() {
        return 1;
    }

}
