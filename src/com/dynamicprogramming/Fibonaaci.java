package com.dynamicprogramming;

public class Fibonaaci {
	
	public static int fib[] = new int[50];	
	
	public static void main(String[] args) {
		//System.out.println("fibonacciMemoization :: " + fibonacciMemoization(6));
		
		System.out.println("fibonacciTabular :: " + fibonacciTabular(6));
	}
	
	private static int fibonacciMemoization(int n) {	
		//Base case
		if(n == 0 || n == 1) {
			return n;
		}
		fib[n] = fibonacciMemoization(n-1) + fibonacciMemoization(n-2);
		return fib[n];		
	}
	
	private static int fibonacciTabular(int n) {		
		//Initial Value in table
		fib[0] = 0;
		fib[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}		
		return fib[n];		
	}

}
