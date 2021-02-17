package com.recursion;

/*
* Time Complexity: T(n) = T(length-1) + c
*  
	O(length)
*/

public class CheckSortedArray {
	public static void main(String args[]) {
		int arr[] = { 10, 36, 75, 99, 98 };
		if (!isArraySorted(arr, arr.length)) {
			System.out.println("Not a Sorted Array");
		} else {
			System.out.println("Sorted Array");
		}
	}

	private static boolean isArraySorted(int arr[], int length) {
		if (length == 1) {
			return true;
		}
		if (arr[length - 1] < arr[length - 2]) {
			return false;
		}
		return isArraySorted(arr, length - 1);
	}

}
