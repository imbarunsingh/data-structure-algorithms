package com.sort;

/*Time Complexity(worst Case) : O(n*n)
Space Complexity : O(n)*/
public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = { 10, 5, 40, 3, 50 };

		boolean isSwapped = false;

		for (int i = 0; i < arr.length - 1; i++) {// n-1 pass

			for (int j = 0; j < arr.length - 1 - i; j++) { // n-1-i comparison for every pass
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSwapped = true;
				}
			}
			if (!isSwapped) {// if the array is sorted and does not need any comparisons
				return;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
