package me.crazydopefox.mcinvbuilder.core.draw;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DrawResult {

    private final int actualHeight;
    private final int actualWidth;

}
