package com.yavdev.section10.ItineraryGuide;

record Place(String name, int distance) {
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Place comparablePlace) {
            return this.name.equalsIgnoreCase(comparablePlace.name) && this.distance == comparablePlace.distance;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", name, distance);
    }
}
