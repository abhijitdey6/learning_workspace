package com.dsa.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] intArr = {20, 35, -15, 7, 55, 1, -22};
		
		//traversing right to left
		for( int lastIndex=intArr.length-1 ; lastIndex > 0; lastIndex--) {
			for(int i=0; i<lastIndex; i++) {
				if(intArr[i] > intArr[i+1]) {
					swap(intArr, i, i+1);
				}
			}
		}
		
		for(int i=0; i<intArr.length; i++)
		{
			System.out.println(intArr[i]);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		if(i==j)
			return;
		
		int temp= arr[i];
		arr[i] = arr[j];
		arr[j]=temp;
		
	}
}
