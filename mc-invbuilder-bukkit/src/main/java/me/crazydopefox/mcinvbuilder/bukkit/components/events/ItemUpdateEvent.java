package me.crazydopefox.mcinvbuilder.bukkit.components.events;

import me.crazydopefox.mcinvbuilder.bukkit.components.InputSlot;
import me.crazydopefox.mcinvbuilder.core.event.Event;

public class ItemUpdateEvent extends Event {
    public ItemUpdateEvent(InputSlot source) {
        super(source);
    }
}
