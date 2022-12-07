package com.java8.streams;

import com.java8.db.Student;
import com.java8.db.StudentDB;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ToMapExample {
    public static void main(String[] args) {
        List<Student> studentList= StudentDB.getAllStudents();
        System.out.println("Convert Student list to map of student name and gender with preserving order");
        System.out.println(convertListToMapWithOrder(studentList));
        System.out.println("Convert Student list to map of student name and student object");
        System.out.println(convertListToMap(studentList));
    }

    public static Map<String,String> convertListToMapWithOrder(List<Student> studentList){
        return studentList.stream()
                .collect(Collectors.toMap(Student::getName,Student::getGender,(a,b)->a+b, LinkedHashMap::new));
    }

    public static Map<String,Student> convertListToMap(List<Student> studentList){
        return studentList.stream()
                .collect(Collectors.toMap(Student::getName,Function.identity()));
    }
}
