package com.recursion;

public class SumOfArrayElements {
	public static void main(String args[]) {
		int arr[] = {1, 2, 3, 4, 5};
		
		int sum = sumOfArrayElements(arr, 0, 0);
		System.out.println("Sum::"+sum);
	}

	private static int sumOfArrayElements(int arr[], int index, int sum) {
		if (index >= arr.length) {
			return sum;
		}
		sum = sum + arr[index];
		return sumOfArrayElements(arr, index+1, sum);
	}
	
}
