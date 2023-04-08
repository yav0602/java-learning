package com.yavdev.section10.ItineraryGuide;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ItineraryGuide {
    private static final Scanner scanner = new Scanner(System.in);
    private final LinkedList<Place> placesList;

    public ItineraryGuide() {
        placesList = new LinkedList<>();
        placesList.addFirst(new Place("Zaporizhzhya", 0));
    }

    public void runGuide() {

        while (true) {
            System.out.println("Welcome to Zaporizhzhya Itinerary Guide");
            System.out.println("--------------------------");
            System.out.println("Choose action: ");
            System.out.println("""
                    1) Add place
                    2) Remove place
                    3) Display places
                    4) Start navigator
                    5) Exit guide
                    """);

            final int action = ItineraryGuide.scanner.nextInt();

            switch (action) {
                case 1 -> this.addPlace();
                case 2 -> this.removePlace();
                case 3 -> this.displayPlaces();
                case 4 -> this.startNavigator();
                case 5 -> {
                    scanner.close();
                    return;
                }
                default -> System.out.println("Wrong action");
            }

        }

    }

    private void displayPlaces() {
        System.out.println(placesList);
    }

    private void addPlace() {
        System.out.println("-----Add place-----");
        System.out.print("Write a place name: ");
        final String name = scanner.next();
        System.out.print("Write a distance from Zaporizhzhya: ");
        final int distance = scanner.nextInt();
        final Place newPlace = new Place(name, distance);

        boolean placeAdded = false;

        if(!placesList.contains(newPlace)) {
            placeAdded = true;
            var placesIterator = placesList.listIterator();

            while(placesIterator.hasNext()) {
                if(newPlace.distance() < placesIterator.next().distance()) {
                    placesIterator.previous();
                    placesIterator.add(newPlace);

                    return;
                }
            }

            placesList.add(newPlace);
        }

        if(placeAdded) {
            System.out.printf("The place %s was added successfully\n", name);
        } else {
            System.out.println("This place is already in places list!");
        }

    }

    private void startNavigator() {
        var placesNavigator = new PlacesNavigator(scanner, placesList);
        placesNavigator.startNavigator();
    }

    private void removePlace() {
        System.out.println("-------Remove Place-------");
        System.out.print("Write place, which you want to remove: ");
        final String removablePlace = scanner.next();
        final Iterator<Place> placesIterator = placesList.iterator();


        while(placesIterator.hasNext()) {
            if(placesIterator.next().name().equals(removablePlace)) {
                placesIterator.remove();
                System.out.printf("The place %s was removed successfully\n", removablePlace);
                break;
            }
        }
    }

 }
