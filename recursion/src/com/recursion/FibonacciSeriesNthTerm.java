package com.recursion;
/*
 * Time Complexity: T(n) = T(n-1) + T(n-2)
 * T(n) = 2T(n-1). 
	O(2 power n)
 */

public class FibonacciSeriesNthTerm {

	public static void main(String args[]) {
		int fibSum = fib(6);
		System.out.print(fibSum);

	}

	private static int fib(int n) {
		if (n <= 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}

}
