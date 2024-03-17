package com.searching.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RepeatingMaximumTimes {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 10, 20, 56, 20 };
		RepeatingMaximumTimesSolution solution = new RepeatingMaximumTimesSolution();
		solution.bruteForceApproach(arr);

		solution.sortAndFind(arr);

		solution.hashtableAndFind(arr);
	}

}

class RepeatingMaximumTimesSolution {

	// Time Complexity : O(n*n)
	public void bruteForceApproach(int arr[]) {
		int max = 0;
		int repeatedElement = 0;
		for (int i = 0; i < arr.length; i++) {
			int counter = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					counter++;
				}
			}
			if (counter > max) {
				max = counter;
				repeatedElement = arr[i];
			}
		}
		System.out.println("The element : " + repeatedElement + " has been found for : " + max + " times");
	}

	// Time Complexity : O(n*logn)
	public void sortAndFind(int arr[]) {
		int counter = 1, max = 0;
		int repeatedElement = 0;
		Arrays.parallelSort(arr);

		for (int i = 0; i < arr.length-1; i++) {			
			if (arr[i] == arr[i + 1]) {
				counter++;
				continue;
			}
			if (counter > max) {
				max = counter;
				counter=1;
				repeatedElement = arr[i];
			}
		}

		System.out.println("The element : " + repeatedElement + " has been found for : " + max + " times");
	}

	public void hashtableAndFind(int arr[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int counter = 0, max = 0;
		int repeatedElement = 0;

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
				continue;
			}
			map.put(arr[i], 1);
		}

		for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
			if (entrySet.getValue() > max) {
				max = entrySet.getValue();
				repeatedElement = entrySet.getKey();
			}

		}
		System.out.println("The element : " + repeatedElement + " has been found for : " + max + " times");
	}

}
