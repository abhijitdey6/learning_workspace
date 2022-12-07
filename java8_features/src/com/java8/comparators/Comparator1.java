package com.java8.comparators;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.java8.db.Student;
import com.java8.db.StudentDB;

public class Comparator1 {

	public static void main(String[] args) {
		List<Student> students=StudentDB.getAllStudents();
		
		Comparator<Student> comp=Comparator.comparingInt(Student::getGradeLevel)
											.thenComparing(Student::getName);

		Collections.sort(students,comp);
		students.forEach(System.out::println);
	}

}
