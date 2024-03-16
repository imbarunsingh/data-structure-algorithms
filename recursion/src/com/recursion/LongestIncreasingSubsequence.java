package com.recursion;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		
		int arr[] = {5, 3, 8, 7, 9, 11};
		
		System.out.println("Longest Increasing sub-sequence count :: " + solveLIS(arr, 0, -1));
		
	}
	
	private static int solveLIS(int arr[], int current, int prev) {
		//base case
		if(current == arr.length) { //when it reaches teh end of the array
			return 0;
		}
		
		int take = 0;
		//include
		if(prev == -1 || arr[current] > arr[prev]) {
			take = 1 + solveLIS(arr, current + 1, current);
		}
		
		
		int notTake = 0;
		//exclude
		notTake = solveLIS(arr, current + 1, prev);
		
		return Math.max(take, notTake);
	}

}
