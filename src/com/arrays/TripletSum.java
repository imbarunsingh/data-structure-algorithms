package com.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripletSum {
	public static void main(String[] args) {
		int arr[] = { -1,0,1,2,-1,-4 }; // Output: [[-1,-1,2],[-1,0,1]]

		List<List<Integer>> results = new ArrayList<>();
		int sum = 0;
		
		//findThreeSumBruteForce(arr, sum, results);
		
		//System.out.println("BruteForce :: " + results);

		findThreeSumOptimal(arr, sum, results);

		System.out.println(results);

	}

	public static void findThreeSumBruteForce(int arr[], int sum, List<List<Integer>> results) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == sum) {
						List<Integer> result = new ArrayList<>();
						result.add(arr[i]);
						result.add(arr[j]);
						result.add(arr[k]);
						results.add(result);
					}
				}
			}
		}
	}

	// Function to find a triplet with a given sum in an array
	public static void findThreeSumOptimal(int arr[], int sum, List<List<Integer>> results) {
		// x + y + z = sum
		//x+y = sum - z and then find for two sum

		// Fix the first element as A[i]
		for (int i = 0; i < arr.length - 2; i++) {
			
			Set<Integer> set = new HashSet<>();
			
			// Calculate the current sum needed to reach the
            // target sum
            int curr_sum = sum - arr[i];
            
            // Iterate through the subarray A[i+1..n-1] to
            // find a pair with the required sum
            for (int j = i + 1; j < arr.length; j++) {
				
            	// Calculate the required value for the
                // second element
                int required_value = curr_sum - arr[j];
                
                if (set.contains(required_value)) {
    				List<Integer> result = new ArrayList<>();
    				result.add(arr[i]);
    				result.add(arr[j]);
    				result.add(required_value);
    				
    				// Triplet is found; print the triplet elements
                    System.out.println("Triplet is " + arr[i] + ", " + arr[j] + ", " + required_value);
    				results.add(result);
    			} else {
    				set.add(arr[j]);
    			}
			}		
			
		}
	}

}
