package com.java8.functionalInterface;

import com.java8.db.Student;
import com.java8.db.StudentDB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionStudentExample {

    static BiFunction<List<Student>, Predicate<Student>, Map<String,Double>> bifunc=
            (students,predicate)->{
                Map<String,Double> mp=new HashMap<>();
                students.forEach((student -> {
                    if(predicate.test(student)){
                        mp.put(student.getName(),student.getGpa());
                    }
                }));
                return mp;
            };
    public static void main(String[] args) {
        List<Student> studentList= StudentDB.getAllStudents();
        System.out.println(bifunc.apply(studentList,PredicateStudentExample.p1));
    }
}
