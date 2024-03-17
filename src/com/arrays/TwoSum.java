package com.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		int arr[] = { 2, 8, 6, 9, 15, 13 };

		List<List<Integer>> results = new ArrayList<>();
		int sum = 15;

		// findTwoSumBruteForce(arr, sum, results);

		findTwoSumOptimal(arr, sum, results);

		System.out.println(results);

	}

	public static void findTwoSumBruteForce(int arr[], int sum, List<List<Integer>> results) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j) {
					continue;
				}
				if (arr[i] + arr[j] == sum) {
					List<Integer> result = new ArrayList<>();
					result.add(arr[i]);
					result.add(arr[j]);

					results.add(result);
				}
			}
		}
	}

	public static void findTwoSumOptimal(int arr[], int sum, List<List<Integer>> results) {
		// x + y = sum
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				List<Integer> result = new ArrayList<>();
				result.add(arr[i]);
				result.add(map.get(arr[i]));

				results.add(result);
			} else {
				map.put(sum - arr[i], arr[i]);
			}
		}
	}

}
