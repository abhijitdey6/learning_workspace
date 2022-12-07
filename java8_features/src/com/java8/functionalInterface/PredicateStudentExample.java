package com.java8.functionalInterface;

import com.java8.db.Student;
import com.java8.db.StudentDB;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

    static Predicate<Student> p1=(st)->{return st.getGpa()>=4.0;};

    public static void filterStudentByGpa(){
        List<Student> students= StudentDB.getAllStudents();
        students.forEach(s->{
            if(p1.test(s)){
                System.out.println(s);
            }
        });
    }
    public static void main(String[] args) {
        filterStudentByGpa();
    }
}
