package com.arrays;

//Refer Anuj Video
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int nums[] = { 4, 5, 6, 7, 0, 1, 2 };

		System.out.println("BruteForce : Elemenet found at index  :: " + searchElementBruteForce(nums, 0));

		System.out.println("Optimal : Elemenet found at index :: " + searchElementOptimal(nums, -5));
	}

	private static int searchElementBruteForce(int arr[], int k) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == k) {
				return i;
			}
		}
		return -1;
	}

	// Time Complexity : O(logn)
	private static int searchElementOptimal(int arr[], int k) {

		int low = 0, high = arr.length - 1;
		int mid;

		while (low <= high) {

			mid = (low + high) / 2;

			if (arr[mid] == k) {
				return mid;
			}

			// check if the left part of mid is sorted
			if (arr[low] < arr[mid]) {
				// check if the value is in the range
				if (k >= arr[low] && k < arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}

			} else {// right part of mid is sorted

				// check if the value is in the range
				if (k > arr[mid] && k <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

}
