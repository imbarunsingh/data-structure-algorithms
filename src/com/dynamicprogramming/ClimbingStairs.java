package com.dynamicprogramming;

import java.util.Scanner;

public class ClimbingStairs {
	
	public static int dp[] = new int[50];	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the staircase number you want to find teh ways for ::");
		int n = scanner.nextInt();
		
		//System.out.println("CountofWays2Reach " + n + "Nth Stair :: " + stairsMemoization(n));
		
		System.out.println("CountofWays2Reach " + n + "Nth Stair :: " + stairsTabular(n));
		
		
	}
	
	private static int stairsMemoization(int n) {	
		//Base case
		if(n == 0 || n == 1) {
			return n;
		}
		// checks if teh value already is calculated and is in array
		if (dp[n] != 0) {
            return dp[n];
        }
		dp[n] = stairsMemoization(n-1) + stairsMemoization(n-2);
		return dp[n];		
	}
	
	//Using Tabulation
	private static int stairsTabular(int n) {		
		//Initial Value in table
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}		
		return dp[n];		
	}

}
