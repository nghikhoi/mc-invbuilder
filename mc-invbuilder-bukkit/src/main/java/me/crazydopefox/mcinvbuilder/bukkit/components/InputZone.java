package me.crazydopefox.mcinvbuilder.bukkit.components;

import lombok.Getter;
import lombok.Setter;
import me.crazydopefox.mcinvbuilder.core.draw.DrawHolder;
import me.crazydopefox.mcinvbuilder.core.draw.IDrawPanel;
import me.crazydopefox.mcinvbuilder.core.draw.components.ObjectGrid;

public class InputZone extends ObjectGrid<ItemWidget> {

    public static final String CONTEXT_KEY_INPUT_ZONE_LIST = "inputZones";

    @Getter @Setter
    private int priority = 0;

    public InputZone(int width, int height) {
        super(width, height);
    }

    @Override
    public void attach(DrawHolder<ItemWidget> holder, IDrawPanel<ItemWidget> panel) {
        super.attach(holder, panel);

    }
}
