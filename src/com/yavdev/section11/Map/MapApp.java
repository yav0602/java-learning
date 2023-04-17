package com.yavdev.section11.Map;

public class MapApp {
    public static void main(String[] args) {
        Mappable building = new Building("School 91", BuildingType.SCHOOL);
        Mappable frontLine = new UtilityLine("Zaporizhzhia Front Line", LineType.FRONT_LINE);

        Mappable.printMap(building);
        System.out.println();
        Mappable.printMap(frontLine);
    }
}
