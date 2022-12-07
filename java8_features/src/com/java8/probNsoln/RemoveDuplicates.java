package com.java8.probNsoln;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");

		// Get list without duplicates
		List<String> distinctItems = list.stream()
		                                    .distinct()
		                                    .collect(Collectors.toList());

		// Let's verify distinct elements
		System.out.println("Using stream distinct method:"+distinctItems);
		
		Set<String> setWithoutDuplicates = list.stream()
				.collect(Collectors.toSet());
				 
				System.out.println("Using Set:"+setWithoutDuplicates);
	}
}
