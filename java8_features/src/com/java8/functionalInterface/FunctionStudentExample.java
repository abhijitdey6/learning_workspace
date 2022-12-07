package com.java8.functionalInterface;

import com.java8.db.Student;
import com.java8.db.StudentDB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudentExample {
    /*Get the Student name and their gpa from student list*/
    static Function<List<Student>, Map<String,Double>> f1=(students)->{
            Map<String,Double> mp=new HashMap<>();
            students.forEach(student -> {
                if(PredicateStudentExample.p1.test(student)) //Fetch only those student whose GPA >=4.0
                    mp.put(student.getName(),student.getGpa());
            });
            return mp;
    };
    public static void main(String[] args) {
        System.out.println(f1.apply(StudentDB.getAllStudents()));
    }
}
