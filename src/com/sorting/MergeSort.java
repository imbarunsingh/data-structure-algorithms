package com.sorting;


/*Time Complexity(worst Case) : O(n*logn)
Space Complexity : O(n)*/
public class MergeSort {

	public static void main(String[] args) {

		int arr[] = { 12, 8, 3, 11, 7, 10, 50, 30 };

		int startIndex = 0;
		int endIndex = arr.length - 1;
		mergeSort(arr, startIndex, endIndex);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void mergeSort(int[] arr, int startIndex, int endIndex) {

		if (startIndex >= endIndex) {
			return;
		}

		int midIndex = (startIndex + endIndex) / 2;
		mergeSort(arr, startIndex, midIndex); // Sort Left Half
		mergeSort(arr, midIndex + 1, endIndex); // Sort Right Half
		merge(arr, startIndex, endIndex, midIndex); // Merge Both Sorted half to a completed sorted Array

	}

	private static void merge(int[] arr, int startIndex, int endIndex, int midIndex) {

		int tempArray[] = new int[endIndex - startIndex + 1];

		// index counter for left side of the array i.e. first half
		int leftSlot = startIndex;
		// index counter for right side of the array i.e. second half
		int rightSlot = midIndex + 1;

		int k = 0; // index counter for temp array

		while (leftSlot <= midIndex && rightSlot <= endIndex) {
			if (arr[leftSlot] < arr[rightSlot]) {
				tempArray[k] = arr[leftSlot];
				leftSlot++;
			} else {
				tempArray[k] = arr[rightSlot];
				rightSlot++;
			}
			k++;
		}

		// For the left over element in left slot
		while (leftSlot <= midIndex) {
			tempArray[k++] = arr[leftSlot++];
		}

		// For the left over element in left slot
		while (rightSlot <= endIndex) {
			tempArray[k++] = arr[rightSlot++];

		}

		// Copy over the temp array into appropriate slots of inputArray
		for (int i = 0; i < tempArray.length; i++) {
			arr[startIndex + i] = tempArray[i];
		}
	}

}
