package com.yavdev.section12.students;

public class ZNUStudent extends Student {
    private boolean isBudget;
    private int rating;

    public ZNUStudent(String name, String courseName, int rating) {
        super(name, courseName);
        this.rating = rating;
        this.isBudget = rating > 50;
    }

    @Override
    public boolean matchFieldValue(String field, String value) {
        if(field.equalsIgnoreCase("rating")) {
            return Integer.parseInt(value) == this.rating;
        };

        return super.matchFieldValue(field, value);
    }

    @Override
    public String toString() {
        return "ZNU" + super.toString() + " | %d%%".formatted(rating);
    }
}
