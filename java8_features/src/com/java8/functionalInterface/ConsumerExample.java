package com.java8.functionalInterface;

import com.java8.db.Student;
import com.java8.db.StudentDB;

import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class ConsumerExample {
    static Consumer<Student> c2=(student)->System.out.println(student);
    static Consumer<Student> c3=(student)->System.out.println(student.getName());
    static Consumer<Student> c4=(student)->System.out.println(student.getActivities());

    public static void main(String[] args) {
        Consumer<String> c1=(s)->System.out.println(s.toUpperCase());
        c1.accept("hello world");
        printName();
        //printNameAndActivities();
        printNameAndActivitiesUsingCondition();
    }

    public static void printName(){
        List<Student> students=StudentDB.getAllStudents();

        students.forEach(c2);
    }

    public static void printNameAndActivities(){
        List<Student> students=StudentDB.getAllStudents();

        students.forEach(c3.andThen(c4));
    }

    public static void printNameAndActivitiesUsingCondition(){
        List<Student> students=StudentDB.getAllStudents();
        students.forEach((student)->{
            if(student.getGpa()>=4.0)
                c3.andThen(c4).accept(student);
        });
    }
}
