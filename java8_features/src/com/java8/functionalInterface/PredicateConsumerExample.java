package com.java8.functionalInterface;

import com.java8.db.Student;
import com.java8.db.StudentDB;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumerExample {

    static Predicate<Student> p1=(st)->{return st.getGpa()>=4.0;};
    static Predicate<Student> p2=(st)->{return st.getGradeLevel()>=3;};

    static BiConsumer<String, List<String>> bc1=(name,activities)-> System.out.println(name +":"+activities);

    static Consumer<Student> sc=(student -> {
        if(p1.and(p2).test(student)){
            bc1.accept(student.getName(),student.getActivities());
        }
    });

    public static void main(String[] args) {

        List<Student> studentList= StudentDB.getAllStudents();
        studentList.forEach(sc);
    }
}
