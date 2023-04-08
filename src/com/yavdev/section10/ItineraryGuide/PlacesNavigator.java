package com.yavdev.section10.ItineraryGuide;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

class PlacesNavigator {
    private final Scanner scanner;
    private final LinkedList<Place> placesList;
    private ListIterator<Place> placesIterator;

    private boolean directionForward = true;

    private boolean isStart = true;
    private boolean isFinish = false;
    private Place currentPlace;

    public PlacesNavigator(Scanner scanner, LinkedList<Place> placesList) {
        this.scanner = scanner;
        this.placesList = placesList;
    }

    protected void startNavigator() {
        System.out.println("-----Places Navigator-----");
        this.placesIterator = placesList.listIterator();

        while(true) {
            this.checkBorders();
            System.out.println("Choose action");
            System.out.println("""
                    1) Go forward
                    2) Go back
                    3) Current location
                    4) Exit from navigator
                    """);

            final int action = this.scanner.nextInt();

            switch(action) {
                case 1 -> this.goForward();
                case 2 -> this.goBack();
                case 3 -> this.displayCurrentLocation();
                case 4 -> {
                    System.out.println("You left the place navigator\nThank you for using it :)");
                    return;
                }
            }
        }
    }

    private void goForward() {
        System.out.println("Action: Going forward");
        if(!directionForward) {
            directionForward = true;
            if(placesIterator.hasNext()) {
                placesIterator.next();
            }
        }

        if(placesIterator.hasNext()) {
            isFinish = false;
            isStart = false;
            currentPlace = placesIterator.next();
        }

    }

    private void goBack() {
        System.out.println("Action: Going back");

        if(directionForward) {
            directionForward = false;
            if(placesIterator.hasPrevious()) {
                placesIterator.previous();
            }
        }

        if (placesIterator.hasPrevious()) {
            isFinish = false;
            isStart = false;
            currentPlace = placesIterator.previous();
        }

    }

    private void checkBorders() {
        if(!placesIterator.hasNext()) {
            isFinish = true;
            directionForward = false;
            currentPlace = placesIterator.previous();
        }
        if(!placesIterator.hasPrevious()) {
            isStart = true;
            directionForward = true;
            currentPlace = placesIterator.next();
        }
    }

    private void displayCurrentLocation() {
        if(isStart) {
            System.out.printf("You are in the start. The place is %s\n", currentPlace.name());
        } else if (isFinish) {
            System.out.printf("You are in the finish. The place is %s\n", currentPlace.name());
        } else {
            System.out.printf("You are in %s\n", currentPlace.name());

        }
    }
}
