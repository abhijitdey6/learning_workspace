package dsa;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindMaxOccurSingleLoop {

	public static void main(String[] args) {
		String input = "this is input string";
		Map<Character, Integer> charCount = new LinkedHashMap<>();
		for (char c : input.toCharArray()) {
		    if (!charCount.containsKey(c)) {
		       charCount.put(c, 1);
		    } else {
		       charCount.put(c, charCount.get(c) + 1);
		    }
		}

		// Here you print the char count:
		/*
		 * for (Entry<Character, Integer> entry : charCount.entrySet()) {
		 * System.out.println(entry.getKey() +"~~"+entry.getValue()); }
		 */

		Entry<Character, Integer> maxEntry = 
				Collections.max(charCount.entrySet(), (Entry<Character, Integer> e1, Entry<Character, Integer> e2) -> e1.getValue().compareTo(e2.getValue()));
		System.out.println(maxEntry.getKey()+"~~"+maxEntry.getValue());
	}

}
