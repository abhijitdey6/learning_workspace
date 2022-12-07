package com.java8.streams;

import com.java8.db.Student;
import com.java8.db.StudentDB;

import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        List<String> studentNameList=StudentDB.getAllStudents().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(studentNameList);
    }
}
