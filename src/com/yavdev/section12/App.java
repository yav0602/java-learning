package com.yavdev.section12;

import com.yavdev.section12.locations.Park;
import com.yavdev.section12.locations.River;
import com.yavdev.section12.map.Layer;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        var riversLayer = new Layer<River<Double>>();
        var parksLayer = new Layer<Park<Double>>();

        var ubileyniyPark = new Park<>(
                "Ubileiniy",
                new ArrayList<>(List.of(9.7865, 10.54356))
        );

        var generationPark = new Park<>(
                "Pokolin'",
                new ArrayList<>(List.of(2.646, 6.543))
        );

        parksLayer.addMappableItem(ubileyniyPark);
        parksLayer.addMappableItem(generationPark);
        parksLayer.renderLayer();

        var dnieperRiver = new River<>(
                "Dnieper",
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(1.1, 1.1)),
                        new ArrayList<>(List.of(2.2, 2.2)),
                        new ArrayList<>(List.of(3.3, 3.3))
                ))
        );
        System.out.println();
        System.out.println("RIVERS");
        System.out.println();
        riversLayer.addMappableItem(dnieperRiver);
        riversLayer.renderLayer();
    }
}
