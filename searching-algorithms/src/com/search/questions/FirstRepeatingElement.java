package com.search.questions;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 10, 20, 56, 12 };
		FirstRepeatingElementSolution solution = new FirstRepeatingElementSolution();
		solution.bruteForceApproach(arr);

		solution.hashtableAndFind(arr);
	}	
}

class FirstRepeatingElementSolution {

	// Time Complexity : O(n*n)
	public void bruteForceApproach(int arr[]) {
		boolean firstDupFound = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					System.out.println("First Duplicate Found : " + arr[i]);
					firstDupFound = true;
					break;
				}
			}
			if (firstDupFound) {
				break;
			}
		}
	}

	// Time Complexity : O(n), space : O(n)
	public void hashtableAndFind(int arr[]) {
		int elemnetFound = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i]) && map.get(arr[i]) > 0) {
				map.put(arr[i], -map.get(arr[i]));
			}
			map.put(arr[i], i + 1);
		}
		int max = 0;
		for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
			if (entrySet.getValue() < 0 && entrySet.getValue() > max) {
				max = entrySet.getValue();
				elemnetFound = entrySet.getKey();
			}
		}
		System.out.println("First Duplicate Found : " + elemnetFound);

	}

}
