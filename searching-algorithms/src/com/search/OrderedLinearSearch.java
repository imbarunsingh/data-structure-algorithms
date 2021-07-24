package com.search;

// Has a Linear Growth Rate with O(n2)
//Linear Search works on both sorted(has a better performance here) and unsorted array(Not that efficient)
public class OrderedLinearSearch {

	public static void main(String[] args) {

		int array[] = { 1, 2, 5, 8, 6, 88, 99 };
		int elementFoundAtIndex = linearSearch(array, 45);

		if (elementFoundAtIndex == -1) {
			System.out.println("The element is not present in the array::");
			return;
		}
		System.out.println("The element is found in the array at index :: " + elementFoundAtIndex);
	}

	private static int linearSearch(int array[], int searchElement) {
		int elementFoundAtIndex = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == searchElement) {
				elementFoundAtIndex = i;
				break;
			}
			if (array[i] > searchElement) {
				System.out.println("Time to return!");
				break;
			}
		}
		return elementFoundAtIndex;
	}
}