package dsa;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Merge2ArrToSortedArr {

	public static void main(String[] args) {
		int a[] = {1, 3, 5, 7}, b[] = {2, 4, 6, 8};
        int size = a.length;
        int size1 = b.length;
         
        // Function call
        System.out.println("Using treemap:");
        mergeArrays(a, b, size, size1);
        System.out.println("\nUsing treeset:");
        mergeArrays2(a, b, size, size1);
	}

	private static void mergeArrays(int[] a, int[] b, int m, int n) {
		Map<Integer,Boolean> mp = new TreeMap<Integer,Boolean>();
	       
        // Inserting values to a map.
        for(int i = 0; i < n; i++)
        {
            mp.put(a[i], true);
        }
        for(int i = 0;i < m;i++)
        {
            mp.put(b[i], true);
        }
       
        // Printing keys of the map.
        for (Map.Entry<Integer,Boolean> me : mp.entrySet())
        {
            System.out.print(me.getKey() + " ");
        }
		
	}

	private static void mergeArrays2(int[] a, int[] b, int m, int n) {
		Set<Integer> sortedSet=new TreeSet<>();
	       
        // Inserting values to a map.
        for(int i = 0; i < n; i++)
        {
        	sortedSet.add(a[i]);
        }
        for(int i = 0;i < m;i++)
        {
        	sortedSet.add(b[i]);
        }
       
        // Printing keys of the map.
        for (Integer me : sortedSet)
        {
            System.out.print(me + " ");
        }
		
	}
}
