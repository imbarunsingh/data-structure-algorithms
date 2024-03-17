package com.arrays;

import java.util.HashSet;

public class TripletSumFinder {

	// Function to find a triplet with a given sum in an
	// array
	public static void
	find3Numbers(int[] A, int arr_size, int sum)
	{
		// Fix the first element as A[i]
		for (int i = 0; i < arr_size - 2; i++) {

			// Create a HashSet to store potential second
			// elements that complement the desired sum
			HashSet<Integer> s = new HashSet<>();

			// Calculate the current sum needed to reach the
			// target sum
			int curr_sum = sum - A[i];

			// Iterate through the subarray A[i+1..n-1] to
			// find a pair with the required sum
			for (int j = i + 1; j < arr_size; j++) {

				// Calculate the required value for the
				// second element
				int required_value = curr_sum - A[j];

				// Check if the required value is present in
				// the HashSet
				if (s.contains(required_value)) {

					// Triplet is found; print the triplet
					// elements
					System.out.println("Triplet is " + A[i]
									+ ", " + A[j] + ", "
									+ required_value);
					//return true;
				} else {
					s.add(A[j]);
				}

				// Add the current element to the HashSet
				// for future complement checks
				
			}
		}

		// If no triplet is found, return false
		//return false;
	}

	public static void main(String[] args)
	{
		int[] A = { -1,0,1,2,-1,-4 };
		int sum = 0;
		int arr_size = A.length;
		
		find3Numbers(A, arr_size, sum);

		// Call the find3Numbers function to find and print
		// the triplet, if it exists
//		if (!find3Numbers(A, arr_size, sum)) {
//			System.out.println(
//				"No triplet found with the given sum.");
//		}
	}
}

