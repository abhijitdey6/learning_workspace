package com.java8.streams;

import com.java8.db.Student;
import com.java8.db.StudentDB;

public class StreamReduce {

	public static void main(String[] args) {
		System.out.println("Combined name:"+combineStudentName());
		System.out.println("Sum of Notbooks:"+sumAllNotebooks());
	}

	/**
	 * Combine All students name with a space
	 * @return String
	 */
	public static String combineStudentName() {
		return StudentDB.getAllStudents().stream()
		.map(Student::getName)
		.distinct()
		.reduce("",(a,b)-> a.concat(" "+b));
	}
	
	/**
	 * Sum all notebooks of the list from StudentDB
	 * @return int
	 */
	public static int sumAllNotebooks() {
		return StudentDB.getAllStudents().stream()
		.map(Student::getNotebooks)
		.reduce(0,(a,b)-> a+b);
	}
}
