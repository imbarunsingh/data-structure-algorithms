package com.sort;

/*Time Complexity(worst Case) : O(n*n)
 * Average and Best Case : O(nlogn)
Space Complexity : O(n)*/
public class QuickSort {
	public static void main(String[] args) {
		int arr[] = { 12, 35, 3, 11, 7, 10, 50, 30 };

		int startIndex = 0;
		int endIndex = arr.length - 1;

		QuickSortSolution quickSortSolution = new QuickSortSolution();
		quickSortSolution.quickSort(arr, startIndex, endIndex);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}

class QuickSortSolution {

	int pivot;

	public void quickSort(int arr[], int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			pivot = partition(arr, startIndex, endIndex);
			quickSort(arr, startIndex, pivot);
			quickSort(arr, pivot + 1, endIndex);
		}
	}

	private int partition(int[] arr, int startIndex, int endIndex) {
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
