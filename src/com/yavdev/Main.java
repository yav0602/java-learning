package com.yavdev;

import com.yavdev.section10.ItineraryGuide.ItineraryGuide;

public class Main {

    public static void main(String[] args) {
        final ItineraryGuide itineraryGuide = new ItineraryGuide();

        itineraryGuide.addPlace("Zaporyzhzhya", 1000);
        itineraryGuide.addPlace("Kyiv", 3000);
        itineraryGuide.addPlace("Ivano-Frankivsk", 2000);
        itineraryGuide.addPlace("Dnipro", 200);

        itineraryGuide.displayPlaces();

    }
}
