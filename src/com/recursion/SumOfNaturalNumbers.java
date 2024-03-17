package com.recursion;
import java.util.*;

public class SumOfNaturalNumbers {
	public static void main(String args[]) {
		System.out.print("Enter the limit::");
		Scanner sc = new Scanner(System.in);
		int limit = sc.nextInt();
		int sum = sumOfNumbers(5, 0);
		System.out.println("Sum::"+sum);
		sc.close();
	}

	private static int sumOfNumbers(int n, int sum) {
		if(n <= 0) {
			return sum;
		}
		sum = sum + n;
		return sumOfNumbers(n-1, sum);
	}
}
