package com.search.questions;

import java.util.HashMap;
import java.util.Map;

// Find missing number in the range of 1 to n
public class RepeatingOddNumberOfTimes {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 2, 3, 1, 3 };
		RepeatingOddNumberOfTimesSolution solution = new RepeatingOddNumberOfTimesSolution();
		solution.hashMapAndFind(arr);

		solution.xorAndFind(arr);

	}

}

class RepeatingOddNumberOfTimesSolution {

	// Time Complexity : O(n), space : O(n)
	public void hashMapAndFind(int arr[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}

		}

		for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
			if (entrySet.getValue() > 1 && entrySet.getValue() % 2 != 0) {
				System.out.println("The number repeating number of times is : " + entrySet.getKey());
			}
		}

	}

	// Time Complexity : O(n), space : O(1)
	public void xorAndFind(int arr[]) {
		int x = 0;
		for (int i = 0; i < arr.length; i++) {
			x = x ^ arr[i];
		}
		System.out.println("The number repeating number of times is : " + x);
	}

}
