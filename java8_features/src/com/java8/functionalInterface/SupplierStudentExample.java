package com.java8.functionalInterface;

import com.java8.db.Student;
import com.java8.db.StudentDB;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierStudentExample {
    public static void main(String[] args) {
        Supplier<Student> studentSupplier=()->{
            return new Student("Sophia", 4, 3.5, "male", 10, Arrays.asList("swimming","dancing","football"));
        };
        System.out.println(studentSupplier.get());

        Supplier<List<Student>> studentList=()-> StudentDB.getAllStudents();
        System.out.println(studentList.get());
    }
}
