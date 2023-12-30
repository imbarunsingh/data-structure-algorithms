package com.recursion;

import java.util.Scanner;

public class SumOfDigits {
	public static void main(String args[]) {
		System.out.print("Enter the number::");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = sumOfDigits(num, 0);
		System.out.println("Sum Of Digits::" + sum);
	}

	private static int sumOfDigits(int num, int sum) {
		if(num <= 0) {
			return sum;
		}
		sum = sum + num % 10;
		return sumOfDigits(num/10, sum);
	}
}
