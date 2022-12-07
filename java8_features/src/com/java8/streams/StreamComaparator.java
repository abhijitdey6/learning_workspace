package com.java8.streams;

import com.java8.db.Student;
import com.java8.db.StudentDB;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamComaparator {

    public static List<Student> sortStudentByName(){
       return StudentDB.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        sortStudentByName().forEach(System.out::println);
    }
}
