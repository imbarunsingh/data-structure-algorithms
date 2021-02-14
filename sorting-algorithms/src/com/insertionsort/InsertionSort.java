package com.insertionsort;

public class InsertionSort {
	public static void main(String[] args) {
		int a[] = {12,8,3,11,7};
		//8,12 j= 1
		int n = a.length;
		
		for(int i = 1 ; i<n; i++) {
			int element = a[i]; //first element in the unsorted part 
			int j = i-1; //last element in the sorted part
			
			while(j >= 0 && a[j] > element) { 
				a[j+1] = a[j];	
				j--;
			}
			a[j+1] = element;
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
