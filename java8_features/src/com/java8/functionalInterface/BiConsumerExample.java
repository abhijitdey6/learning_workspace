package com.java8.functionalInterface;

import com.java8.db.Student;
import com.java8.db.StudentDB;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String,String> bc1=(s1,s2)-> System.out.println("s1:"+s1+",s2:"+s2);
        bc1.accept("java7","java8");

        printNameAndActivities();
    }

    public static void printNameAndActivities(){
        BiConsumer<String,List<String>> bc2=(student,activities)-> System.out.println(student+":"+activities);
        List<Student> studentList= StudentDB.getAllStudents();
        studentList.forEach((student)-> bc2.accept(student.getName(),student.getActivities()));
    }
}
