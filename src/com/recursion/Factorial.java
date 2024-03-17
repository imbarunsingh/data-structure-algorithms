package com.recursion;

import java.util.Scanner;

/*
 * Time Complexity: T(n) = T(n-1) + c
 *
	O(n)
 */
public class Factorial {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter any number: ");

		int factorialNum = scan.nextInt();
		System.out.println("The factorial of " + factorialNum + " is : " + fact(factorialNum));
	}
	
	private static int fact(int n) {
		if (n == 0)  {
			return 1;
		}
		return n * fact(n-1);
	}

}
