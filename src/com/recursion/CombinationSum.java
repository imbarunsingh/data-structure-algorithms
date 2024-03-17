package com.recursion;

import java.util.ArrayList;
import java.util.List;

//refer strivers video and babbar
public class CombinationSum {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 6, 7 };
		List<List<Integer>> responseList = new ArrayList<>();
		
		combinationSum(arr, responseList, 7, 0, new ArrayList<>());
		responseList.stream().forEach(x -> System.out.println(x));

	}

	private static void combinationSum(int arr[], List<List<Integer>> responseList, int target, int index, List<Integer> response) {
		if (index == arr.length) {
			if (target == 0) {
				responseList.add(new ArrayList<>(response));
			}
			return;
		}

		if (arr[index] <= target) {
			response.add(arr[index]);
			combinationSum(arr, responseList, target - arr[index], index, response);
			response.remove(response.size() - 1); // backtracking
		}
		//not take
		combinationSum(arr, responseList, target, index + 1, response);
	}
}
