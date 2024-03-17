package com.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Refer Nishant Chahar Youtube video for explanation
//Time c omplexity : O(2^n)
public class SubsetWithSpecificSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sourceArr[] = { 1, 2, 3, 4 };

		System.out.print("Enter the value for sum you wnat to finding all Subsequences ::");
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt();
			printSS(sourceArr, new ArrayList<>(), 0, k);
		}

	}

	private static void printSS(int sourceArr[], List<Integer> responseList, int index, int k) {
		if (index == sourceArr.length) {
			int sum = 0;
			for (Integer integer : responseList) {
				sum = sum + integer;
			}
			if (sum == k) {
				System.out.println(responseList);
			}
			return;
		}
		// take case
		responseList.add(sourceArr[index]);
		printSS(sourceArr, responseList, index + 1, k);
		// not take case
		responseList.remove(responseList.size() - 1);
		printSS(sourceArr, responseList, index + 1, k);
	}
}
