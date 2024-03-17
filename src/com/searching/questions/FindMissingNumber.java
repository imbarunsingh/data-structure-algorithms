package com.searching.questions;

// Find missing number in the range of 1 to n
public class FindMissingNumber {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 9, 10 };
		FindMissingNumberSolution solution = new FindMissingNumberSolution();
		solution.bruteForceApproach(arr, 10);

		solution.sumOfNaturalNumbersWay(arr, 10);

		solution.xorAndFind(arr, 10);
	}

}

class FindMissingNumberSolution {

	// Time Complexity : O(n*n)
	public void bruteForceApproach(int arr[], int n) {
		for (int i = 1; i < n; i++) {
			boolean isElementFound = false;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == i) {
					isElementFound = true;
					break;
				}
			}
			if (!isElementFound) {
				System.out.println("Missing Number : " + i);
			}
		}
	}

	// Time Complexity : O(n)
	public void sumOfNaturalNumbersWay(int arr[], int n) {

		int sumOfNaturalNumbers = n * (n + 1) / 2;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		int diff = sumOfNaturalNumbers - sum;
		if (diff > 0) {
			System.out.println("Missing Number : " + diff);
		}
	}

	// Time Complexity : O(n), space : O(1)
	public void xorAndFind(int arr[], int n) {
		int x = 0, y = 0;
		
		for (int i = 0; i < arr.length; i++) {
			x = x ^ arr[i];
		}

		for (int i = 1; i <= n; i++) {
			y = y ^ i;
		}

		x = x ^ y;

		System.out.println("Missing Number : " + x);
	}

}
