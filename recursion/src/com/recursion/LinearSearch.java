package com.recursion;


public class LinearSearch {
	public static void main(String[] args) {

		int array[] = { 2, 4, 6, 8, 11, 33, 22, 34, 55, 88, 12 };
		int numberToBeSearched = 12;
		int elementFoundAtIndex = linearSearch(array, 0, numberToBeSearched);

		if (elementFoundAtIndex == -1) {
			System.out.println("The element you are looking for is not found::");
			return;
		}
		System.out.println("The element you are looking for is found at index:: " + elementFoundAtIndex);

	}

	private static int linearSearch(int[] array, int index, int numberToBeSearched) {
		if (array.length - 1 < index) {
			throw new IndexOutOfBoundsException("Invalid Index");
		} else if (array[index] == numberToBeSearched) {
			return index;
		} else {
			System.out.println("Index At::"+index);
			return linearSearch(array, index + 1, numberToBeSearched);
		}
	}

}
