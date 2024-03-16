package com.recursion;

import java.util.Scanner;

/*This is like fibonaci series with only change in base case
Refer Video by Nishant Chahar*/

public class CountWays2ReachNthStairProblem {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the staircase number you want to find teh ways for ::");
			int n = scanner.nextInt();
			int countOfWays2ReachNthStair = fib(n+1);
			System.out.println("CountofWays2Reach " + n + "Nth Stair :: " + countOfWays2ReachNthStair);
		}
	}

	public static int fib(int n) {
		if (n <= 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}

}
