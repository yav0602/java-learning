package com.yavdev.section10.ItineraryGuide;

record Town(String name, int distance) {
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Town comparableTown) {
            return this.name.equalsIgnoreCase(comparableTown.name) && this.distance == comparableTown.distance;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", name, distance);
    }
}
