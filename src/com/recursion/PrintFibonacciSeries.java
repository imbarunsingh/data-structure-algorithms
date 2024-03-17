package com.recursion;

import java.util.Scanner;

/*	O(branches power n)
 * Time Complexity: T(n) = T(n-1) + T(n-2)
 * T(n) = 2T(n-1). 
	O(2 power n)
 */

public class PrintFibonacciSeries {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter any number: ");

		int fibSeriesSize = scan.nextInt();
		System.out.print("Fibonacci Series of " + fibSeriesSize + " numbers: ");
		for (int i = 0; i < fibSeriesSize; i++) {
			System.out.print(fib(i) + " ");
		}
	}

	public static int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

}
