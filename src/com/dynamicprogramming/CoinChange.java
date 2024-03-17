package com.dynamicprogramming;

//Time Complexity: O(amt*coins).
//Auxiliary Space: O(coins) because using extra space for array table

public class CoinChange {
	public static void main(String[] args) {
		int coins[] = {1, 2, 5};
		int amount = 11;
		
		int dp[] = new int[amount+1];
		
		
		System.out.println("Minimum coins to make : " + amount + " is :: " + solveTabulation(amount, coins, dp));
	}
	
	private static int solveTabulation(int amount, int coins[], int dp[]) {
		dp[0] = 0;
		
		// solving for every amount figure from 1 to amount
		for (int i = 1; i <= amount; i++) {
			// Initialize all table values as Infinite
			dp[i] = Integer.MAX_VALUE;
			
			// Go through all coins smaller than i
			for (int j = 0; j < coins.length; j++) {
				
				if (coins[j] <= i) {
					
					int sub_res = dp[i - coins[j]];
					
					if (sub_res != Integer.MAX_VALUE) { // checking if this already exists
						dp[i] = Math.min(dp[i], sub_res + 1);
					}
		                       
				}	
			}		
			
		}
		if(dp[amount] == Integer.MAX_VALUE) {
			return -1;
		}
		
		return dp[amount];
	}
	
	
	

}
