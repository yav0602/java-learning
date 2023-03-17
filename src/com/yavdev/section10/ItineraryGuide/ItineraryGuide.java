package com.yavdev.section10.ItineraryGuide;

import java.util.LinkedList;

public class ItineraryGuide {
    private final LinkedList<Town> placesList;

    public ItineraryGuide() {
        placesList = new LinkedList<>();
    }

    public void addPlace(String name, int distance) {
        Town newTown = new Town(name, distance);

        if(!placesList.contains(newTown)) {
            var placesIterator = placesList.listIterator();

            while(placesIterator.hasNext()) {
                if(newTown.distance() < placesIterator.next().distance()) {
                    placesIterator.previous();
                    placesIterator.add(newTown);

                    return;
                }
            }

            placesList.add(newTown);
        }
    }

    public void displayPlaces() {
        System.out.println(placesList);
    }
}
