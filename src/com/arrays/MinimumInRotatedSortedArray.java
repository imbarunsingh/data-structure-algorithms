package com.arrays;

//Refer Anuj Video
public class MinimumInRotatedSortedArray {

	public static void main(String[] args) {
		int nums[] = { 4, 5, 6, 7, 11, 1, 2 };

		System.out.println("BruteForce : Minimum element :: " + minimumElementBruteForce(nums));

		System.out.println("Optimal : Minimum element :: " + minimumElementOptimal(nums));
	}

	private static int minimumElementBruteForce(int arr[]) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	// Time Complexity : O(logn)
	private static int minimumElementOptimal(int arr[]) {

		int low = 0, high = arr.length - 1;
		int mid;

		int min = Integer.MAX_VALUE;

		while (low <= high) {

			mid = (low + high) / 2;

			// check if the left part of mid is sorted
			if (arr[low] <= arr[mid]) { // == for single element array
				min = Math.min(min, arr[low]); // taking the first element in left part sorted as min

				//discard the left sorted part after taking min from it
				low = mid + 1;

			} else {// right part of mid is sorted

				min = Math.min(min, arr[mid]);

				//discard the right sorted part after taking min from it
				high = mid - 1;
			}
		}
		return min;
	}

}
