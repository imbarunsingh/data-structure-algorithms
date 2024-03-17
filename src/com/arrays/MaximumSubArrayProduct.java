package com.arrays;

//Kadanes Algorithm
public class MaximumSubArrayProduct { 
	public static void main(String[] args) {
		int arr[] = {5,4,-1,7,8};	//23 is max
		
		//int arr[] = {2,3,-2,4}; // [2,3] has the largest product 6.
		
		System.out.println("Maximum Product-> Brute :: " + maximumSubArrayBruteForce(arr));
		
		System.out.println("Maximum Product -> Optimal :: " + maximumSubArrayOptimal(arr));
	}
	
	public static int maximumSubArrayBruteForce(int arr[]) {
		int maxProduct = 1;
		for (int i = 0; i < arr.length; i++) {
			int product = 1;
			for (int j = i; j < arr.length; j++) {
				product = product * arr[j];
				maxProduct = Math.max(maxProduct, product); // to ignore -1
			}						
		}
		return maxProduct;
	}
	
	public static int maximumSubArrayOptimal(int arr[]) {
		int maxProduct = 1;
		int product = 1 ;
		
		for (int i = 0; i < arr.length; i++) {
			product = product * arr[i];
			
			maxProduct = Math.max(maxProduct, product);

			if(product < 0) {
				product = 1;
			}
		}		
		return maxProduct;
	}

}
