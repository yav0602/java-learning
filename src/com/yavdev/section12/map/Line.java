package com.yavdev.section12.map;

import java.util.ArrayList;
import java.util.List;

public class Line<T> implements Mappable {

    private final List<List<T>> coordinates;

    public Line(List<List<T>> points) {
        if (this.validateCoordinates(points)) {
            this.coordinates = points;
        } else {
            this.coordinates = new ArrayList<>();
            System.out.println("Your coordinates format are incorrect, so the coordinates variable is empty");
        }
    }

    @Override
    public void render() {
        final var coordinatesIterator = coordinates.iterator();
        var previousPoint = coordinatesIterator.next();

        System.out.println("BEGINNING OF LINE");
        while (coordinatesIterator.hasNext()) {
            final var currentPoint = coordinatesIterator.next();
            String stringifyPreviousCoordinates = "[" + previousPoint.get(0) + "; " + previousPoint.get(1) + "]";
            String stringifyCurrentCoordinates = "[" + currentPoint.get(0) + "; " + currentPoint.get(1) + "]";

            System.out.printf("""
                    LINE from %s to %s,
                    """, stringifyPreviousCoordinates, stringifyCurrentCoordinates);

            previousPoint = currentPoint;
        }
        System.out.println("END OF LINE");
    }

    private boolean validateCoordinates(List<List<T>> coordinatesArray) {
        boolean valid = true;

        for (var pointCoordinates : coordinatesArray) {
            valid = valid && pointCoordinates.size() == 2;
        }

        return valid;
    }
}
