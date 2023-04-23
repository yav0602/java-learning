package com.yavdev.section12.locations;

import com.yavdev.section12.map.Line;

import java.util.List;

public class River<T> extends Line<T> {
    private final String name;
    private final LocationType type = LocationType.RIVER;

    public River(String name, List<List<T>> points) {
        super(points);
        this.name = name;
    }

    @Override
    public void render() {
        System.out.printf("""
                Rendering "%s" %s's line\n
                """, this.name, this.type.toString().toLowerCase());
        super.render();
    }
}
