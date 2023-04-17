package com.yavdev.section11.Map;

enum BuildingType {
    GOVERNMENT,
    ENTERTAINMENT,
    SCHOOL,
}

public class Building extends MapPoint {
    private BuildingType buildingType;

    public Building(String name, BuildingType buildingType) {
        super(
                name,
                GeometryType.POINT,
                switch(buildingType) {
                    case GOVERNMENT -> "GREEN" + " " + PointMarker.SQUARE;
                    case ENTERTAINMENT -> "RED" + " " + PointMarker.TRIANGLE;
                    case SCHOOL -> "BLUE" + " " + PointMarker.CIRCLE;
                }
        );
        this.buildingType = buildingType;
    }

    @Override
    public String getLabel() {
        final var name = super.getLabel();
        return "%s (%s)".formatted(name, buildingType);
    }

    @Override
    public String toJSON() {
        final var name = super.getLabel();
        return """
               %s, "name": "%s", buildingType: "%s" """.formatted(super.toJSON(), name, buildingType);
    }
}
