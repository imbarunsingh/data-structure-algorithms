package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		
		int arr[] = {5, 3, 8, 7, 9, 11};
		
		System.out.println("Longest Increasing sub-sequence count :: " + solveOptimal(arr));
		
	}
	
	private static int solveOptimal(int arr[]) {
		//base case
		if(arr.length == 0) { //when it reaches teh end of the array
			return 0;
		}
		List<Integer> ans = new ArrayList<>();
		ans.add(arr[0]);
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] > ans.get(ans.size() - 1)) {
				ans.add(arr[i]);
			} else {
				 // Replacement step
				int index = Collections.binarySearch(ans, arr[i]);
				System.out.println(index);
				
				//if the element not found in ans
				if (index < 0) {
                    index = -index - 1;
                }				
				ans.set(index, arr[i]);
			}
			
		}
		System.out.println(ans);
		
		return ans.size();
	}

}
