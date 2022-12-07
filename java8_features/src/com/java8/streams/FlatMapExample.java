package com.java8.streams;

import com.java8.db.Student;
import com.java8.db.StudentDB;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        Set<String> activityList=StudentDB.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        System.out.println(activityList);
        //Using List
        List<String> activityList1=StudentDB.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(activityList1);
        System.out.println("count:"+countStudentActivities());
        System.out.println("sorted:"+sortStudentActivities());
    }

    public static long countStudentActivities(){
        return StudentDB.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
    }

    public static List<String> sortStudentActivities(){
        return StudentDB.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
