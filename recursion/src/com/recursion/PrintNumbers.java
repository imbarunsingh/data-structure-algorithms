package com.recursion;

import java.lang.*;
import java.util.*;

public class PrintNumbers {
	public static void main(String args[]) {
		System.out.println("Enter the value for n : ->");
		Scanner sc = new Scanner(System.in);
		int limit = sc.nextInt();
		System.out.println("Printing numbers 1 to " + limit);
		print(1, limit);
	}

	private static void print(int i, int n) {
		if (i > n) {
			return;
		}
		System.out.println(i);
		print(i + 1, n);
	}
}
