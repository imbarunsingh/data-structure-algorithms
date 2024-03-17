package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Refer Nishant and Babbar videos
//Time Complexity : O(n*n!)
public class PermutationOfArray {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		int arr[] = { 1, 2, 3 };
		List<List<Integer>> reponseList = new ArrayList<>();
		permute(arr, reponseList, 0);

		for (List<Integer> response : reponseList) {
			System.out.println(response);
		}
	}

	private static void permute(int arr[], List<List<Integer>> reponseList, int index) {
		if (index == arr.length) {
			List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
			reponseList.add(list);
			return;
		}

		for (int i = index; i < arr.length; i++) {
			swap(arr, index, i);
			permute(arr, reponseList, index + 1);
			// backtracking to get the original array
			swap(arr, index, i);
		}
	}

	private static void swap(int arr[], int sourceIndex, int targetIndex) {
		int third = arr[sourceIndex];
		arr[sourceIndex] = arr[targetIndex];
		arr[targetIndex] = third;
	}

}
