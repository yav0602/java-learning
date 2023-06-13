package com.yavdev.section12.students;

import java.util.Random;

public class Student implements QueryItem, Comparable<Student> {
    private static int STUDENT_ID = 0;
    private final int id;
    private final String name;
    private final String courseName;

    public Student(String name, String courseName) {
        this.name = name;
        this.courseName = courseName;
        this.id = STUDENT_ID++;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public boolean matchFieldValue(String field, String value) {
        return switch(field) {
           case "id" -> this.id == Integer.parseInt(value);
           case "name" -> this.name.equals(value);
           case "courseName" -> this.courseName.equals(value);
           default -> false;
        };
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return "Student: %d | %s | %s".formatted(id, name, courseName);
    }
}
