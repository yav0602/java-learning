package com.yavdev.section11.Map;

enum GeometryType {
    POINT,
    LINE,
}

enum PointMarker {
    CIRCLE,
    SQUARE,
    TRIANGLE,
}

enum LineMarker {
    SOLID,
    DASHED,
    WAVE,
}

public interface Mappable {
    String JSON_PROPERTY = "\"properties\": { %s }";

    String getLabel();

    String getMarker();

    GeometryType getType();

    default String toJSON() {
        return "\"label\": \"%s\", \"marker\": \"%s\", \"type\": \"%s\"".formatted(getLabel(), getMarker(), getType());
    }

    static void printMap(Mappable map) {
        System.out.println(Mappable.JSON_PROPERTY.formatted(map.toJSON()));
    }
}
