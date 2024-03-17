package com.recursion;

import java.util.Scanner;

public class PrintNumbersReverseOrder {
	public static void main(String args[]) {
		System.out.print("Enter the value for n : ->");
		Scanner sc = new Scanner(System.in);
		int limit = sc.nextInt();
		System.out.println("Printing numbers " + limit + " to 1");
		print(limit);
	}

	private static void print(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		print(n - 1);
	}
}
