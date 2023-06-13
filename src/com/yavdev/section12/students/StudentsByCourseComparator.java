package com.yavdev.section12.students;

import java.util.Comparator;

public class StudentsByCourseComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getCourseName().compareTo(o2.getCourseName());
    }
}
