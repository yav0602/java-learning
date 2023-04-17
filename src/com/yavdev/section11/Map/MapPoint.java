package com.yavdev.section11.Map;

public abstract class MapPoint implements Mappable {
    private String name;
    private GeometryType geometryType;
    private String marker;

    public MapPoint(String name, GeometryType geometryType, String marker) {
        this.name = name;
        this.geometryType = geometryType;
        this.marker = marker;
    }

    @Override
    public String getLabel() {
        return name;
    }

    @Override
    public String getMarker() {
        return marker;
    }

    @Override
    public GeometryType getType() {
        return geometryType;
    }
}
