package com.searching.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindDuplicate {
	public static void main(String[] args) {
		int arr[] = {10,20,30,40,20,56,12};
		FindDuplicateSolution findDuplicateSolution = new FindDuplicateSolution();
		findDuplicateSolution.bruteForceApproach(arr);
		
		findDuplicateSolution.sortAndFind(arr);
		
		findDuplicateSolution.hashtableAndFind(arr);
	}

}

class FindDuplicateSolution {

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

		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i] == arr[i + 1]) {
				System.out.println("Duplicate Found : " + arr[i]);
				break;
			}
		}

	}

	// Time Complexity : O(n), space : O(n)
	public void hashtableAndFind(int arr[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				System.out.println("Duplicate Found : " + arr[i]);
				break;
			}
			map.put(arr[i], i);
		}
	}

}
