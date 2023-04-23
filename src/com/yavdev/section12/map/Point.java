package com.yavdev.section12.map;

import java.util.ArrayList;
import java.util.List;

public class Point<T> implements Mappable {
    private final List<T> coordinates;

    public Point(List<T> coordinates) {
        if(this.validateCoordinates(coordinates)) {
            this.coordinates = coordinates;
        } else {
            this.coordinates = new ArrayList<>(2);
            System.out.println("Your coordinates format are incorrect, so the coordinates variable is empty");
        }
    }

    @Override
    public void render() {
        System.out.println("Coordinates of point are [" + coordinates.get(0) + "; " + coordinates.get(1) + "]");
    }

    private boolean validateCoordinates(List<T> coordinates) {
        return coordinates.size() == 2;
    };
}
