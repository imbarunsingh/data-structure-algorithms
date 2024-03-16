package com.recursion;

public class CoinChange {
	public static void main(String[] args) {
		int coins[] = {1, 2, 5};
		int amount = 11;
		
		System.out.println("Minimum coins to make : " + amount + " is :: " + solveRec(amount, coins));
	}
	
	private static int solveRec(int amount, int coins[]) {
		//Base case
		if(amount == 0) {
			return amount;
		}
		if(amount < 0) {
			return Integer.MAX_VALUE;
		}
		
		int mini = Integer.MAX_VALUE;
		
		for (int i = 0; i < coins.length; i++) {
			int ans = solveRec(amount - coins[i], coins);
			
			if (ans != Integer.MAX_VALUE) {
				mini = Math.min(mini, ans + 1); // plus one to ans as cnsidering teh current coins as well
			}
		}		
		return mini;
	}
	
	
	

}
