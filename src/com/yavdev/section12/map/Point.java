package com.yavdev.section12.map;

import java.util.ArrayList;

public class Point<T extends ArrayList> implements Mappable {
    private final T coordinates;

    public Point(T coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public void render() {
        System.out.println("Coordinates of point are [" + coordinates.get(0) + "; " + coordinates.get(1) + "]");
    }

    private boolean validateCoordinates(T coordinates) {
        return coordinates.size() == 2;
    };
}
