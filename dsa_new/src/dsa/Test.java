package dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		String[] arr = {"tea","eat","god","dog","free","bat","tab"};
		int len=arr.length;
		wordWithSameCharset(arr,len);
	}

	static void wordWithSameCharset(String[] arr,int n){
		HashMap<Integer, ArrayList<String>> mp=new HashMap<>();
		for(int i=0; i<n; i++){
			int key=getKey(arr[i]);
			if(mp.containsKey(key)){
				List<String> str=mp.get(key);
				str.add(arr[i]);
				mp.put(key, (ArrayList<String>) str);
			}else{
				List<String> str=new ArrayList<>();
				str.add(arr[i]);
				mp.put(key, (ArrayList<String>) str);
			}
		}

		for(Map.Entry<Integer,ArrayList<String>> entry:mp.entrySet()){
			System.out.println(entry.getKey()+"~~"+entry.getValue());
		}
	}

	private static int getKey(String s) {
		int sum=0;
		char[] cArr=s.toCharArray();
		for(int c:cArr) {
			//System.out.println((char)c +":"+c);
			sum += c;
		}
		return sum;
	}
}
