package com.java8.streams;

import java.util.List;
import java.util.stream.Collectors;

import com.java8.db.Student;
import com.java8.db.StudentDB;

public class StreamFilter {

	public static void main(String[] args) {
		System.out.println("Filtered:"+filteredStudentList());

	}

	/**Filter all students whose gpa > 3.9 and gender = female
	 * @return List<Student>
	 */
	public static List<Student> filteredStudentList() {
		List<Student> studentsFiltered=StudentDB.getAllStudents()
				.stream().filter(student -> student.getGpa()>3.9)
				.filter(student -> student.getGender().equals("female"))
				.collect(Collectors.toList());
		
		return studentsFiltered;
	}
}
