package com.selection;

/*
Worst-case performance: О(n2) : if sorted arrays
Best-case performance: О(n)
Average performance: O(n)
*/
public class KthSmallest {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 40, 5, 60, 80 };
		int index = quickSelect(arr, 0, arr.length - 1, 3 - 1); // 3rd smallest element index would be 2
		System.out.println("The 3rd smallest element is : " + arr[index]);
	}

	private static int quickSelect(int[] arr, int low, int high, int k) {
		int pivotIndex = partition(arr, low, high);

		if (k < pivotIndex) {
			return quickSelect(arr, low, pivotIndex, k);
		} else if (k > pivotIndex) {
			return quickSelect(arr, pivotIndex + 1, high, k);
		} else {
			return pivotIndex;
		}
	}

	private static int partition(int[] arr, int startIndex, int endIndex) {
		int low = startIndex;
		int pivot = arr[startIndex];

		while (startIndex < endIndex) {
			// Move start index while item is smaller than pivot
			while (arr[startIndex] <= pivot) {
				startIndex++;
			}
			// Move end index while item is greater than pivot
			while (arr[endIndex] > pivot) {
				endIndex--;
			}

			// Swap elements
			if (startIndex < endIndex) {
				int temp = arr[startIndex];
				arr[startIndex] = arr[endIndex];
				arr[endIndex] = temp;
			}

		}

		// Swap pivot element with the partition index
		int temp = arr[low];
		arr[low] = arr[endIndex];
		arr[endIndex] = temp;

		return endIndex;
	}

}
