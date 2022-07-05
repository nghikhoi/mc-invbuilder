package me.crazydopefox.mcinvbuilder.core.draw;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class DrawHolder<T> {

    @Getter
    private final IWidget<T> drawable;
    @Getter
    private final IDrawPanel<T> drawPanel;

    private final Map<String, Object> contextMap = new HashMap<>();

    public void setContext(String key, Object value) {
        contextMap.put(key, value);
    }

    public Object getContext(String key) {
        return contextMap.get(key);
    }

    public void build() {
        drawable.attach(this, drawPanel);
    }

}
