package com.yavdev.section12.locations;

import com.yavdev.section12.map.Line;

import java.util.ArrayList;

public class River<T extends ArrayList<ArrayList>> extends Line<T> {
    private final String name;
    private final LocationType type = LocationType.RIVER;

    public River(String name, T points) {
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
