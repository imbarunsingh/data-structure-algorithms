package com.searching.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTwoRepeatingNumbers {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 20, 10, 12 };
		FindTwoRepeatingNumbersSolution solution = new FindTwoRepeatingNumbersSolution();
		solution.bruteForceApproach(arr);

		System.out.println("----------------------");
		solution.sortAndFind(arr);

		System.out.println("----------------------");
		solution.hashtableAndFind(arr);
	}

}

class FindTwoRepeatingNumbersSolution {

	// Time Complexity : O(n*n)
	public void bruteForceApproach(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					System.out.println("Duplicate Found : " + arr[i]);
					break;
				}
			}
		}
	}

	// Time Complexity : O(n*logn)
	public void sortAndFind(int arr[]) {
		Arrays.parallelSort(arr);

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				System.out.println("Duplicate Found : " + arr[i]);
			}
		}

	}

	// Time Complexity : O(n), space : O(n)
	public void hashtableAndFind(int arr[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				System.out.println("Duplicate Found : " + arr[i]);
			}
			map.put(arr[i], i);
		}
	}

}
