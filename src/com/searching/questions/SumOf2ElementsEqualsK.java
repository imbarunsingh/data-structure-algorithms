package com.searching.questions;

import java.util.HashMap;
import java.util.Map;

public class SumOf2ElementsEqualsK {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 20, 56, 12 };
		SumOf2ElementsEqualsKSolution solution = new SumOf2ElementsEqualsKSolution();
		solution.bruteForceApproach(arr, 22);

		solution.hashtableAndFind(arr, 22);
	}

}

class SumOf2ElementsEqualsKSolution {

	// Time Complexity : O(n*n)
	public void bruteForceApproach(int arr[], int k) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == k) {
					System.out.println("Two elemnts are  : " + arr[i] + " and " + arr[j]);
					break;
				}
			}
		}
	}

	// Time Complexity : O(n), space : O(n)
	public void hashtableAndFind(int arr[], int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				System.out.println("Two elemnts are  : " + arr[map.get(arr[i])] + " and " + arr[i]);

			}
			map.put(k - arr[i], i);
		}
	}

}
