package com.yavdev.section11.Map;

enum LineType {
    FIBER_OPTIC,
    ELECTRICITY,
    FRONT_LINE,

}

public class UtilityLine extends MapPoint {
    private LineType lineType;

    public UtilityLine(String name, LineType lineType) {
        super(
                name,
                GeometryType.LINE,
                switch(lineType) {
                    case FRONT_LINE -> "RED" + " " + LineMarker.SOLID;
                    case ELECTRICITY -> "BLUE" + " " + LineMarker.DASHED;
                    case FIBER_OPTIC -> "YELLOW" + " " + LineMarker.WAVE;
                }
        );
        this.lineType = lineType;
    }

    @Override
    public String getLabel() {
        final var name = super.getLabel();
        return "%s (%s)".formatted(name, lineType);
    }

    @Override
    public String toJSON() {
        final var name = super.getLabel();
        return """
               %s, "name": "%s", buildingType: "%s" """.formatted(super.toJSON(), name, lineType);
    }
}
