package com.yavdev.section12.locations;

import com.yavdev.section12.map.Point;

import java.util.List;

public class Park<T> extends Point<T> {
    private final String name;
    private final LocationType type = LocationType.PARK;

    public Park(String name, List<T> coordinates) {
        super(coordinates);
        this.name = name;
    }

    @Override
    public void render() {
        System.out.printf("""
                Rendering "%s" %s's point
                """, this.name, this.type.toString().toLowerCase());

        super.render();
        System.out.println();
    }
}
