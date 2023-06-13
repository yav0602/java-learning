package com.yavdev.section12;

import com.yavdev.section12.locations.Park;
import com.yavdev.section12.locations.River;
import com.yavdev.section12.map.Layer;
import com.yavdev.section12.students.QueryList;
import com.yavdev.section12.students.Student;
import com.yavdev.section12.students.ZNUStudent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
//        var riversLayer = new Layer<River<Double>>();
//        var parksLayer = new Layer<Park<Double>>();
//
//        var ubileyniyPark = new Park<>(
//                "Ubileiniy",
//                new ArrayList<>(List.of(9.7865, 10.54356))
//        );
//
//        var generationPark = new Park<>(
//                "Pokolin'",
//                new ArrayList<>(List.of(2.646, 6.543))
//        );
//
//        parksLayer.addMappableItem(ubileyniyPark);
//        parksLayer.addMappableItem(generationPark);
//        parksLayer.renderLayer();
//
//        var dnieperRiver = new River<>(
//                "Dnieper",
//                new ArrayList<>(List.of(
//                        new ArrayList<>(List.of(1.1, 2.1)),
//                        new ArrayList<>(List.of(2.2, 2.2)),
//                        new ArrayList<>(List.of(3.3, 3.3))
//                ))
//        );
//        System.out.println();
//        System.out.println("RIVERS");
//        System.out.println();
//        riversLayer.addMappableItem(dnieperRiver);
//        riversLayer.renderLayer();

        Student artur = new Student("Artur", "English");
        Student nikolay = new Student("Nikolay", "English");
        Student alexey = new Student("Alexey", "English");
        Student ilia = new Student("Ilia", "Frontend");
        ZNUStudent kirill = new ZNUStudent("Kirill", "Frontend", 90);
        ZNUStudent oleksandr = new ZNUStudent("Oleksandr", "Frontend", 91);
        ZNUStudent maxim = new ZNUStudent("Maxim", "Frontend", 93);

        QueryList<Student> studentsList = new QueryList<>(List.of(kirill, maxim, alexey, nikolay, ilia, oleksandr,artur ));

        System.out.println(studentsList.filter("rating", "90"));

        System.out.println();
        System.out.println(studentsList);
        studentsList.sort(Comparator.naturalOrder());
        System.out.println(studentsList);
    }
}
