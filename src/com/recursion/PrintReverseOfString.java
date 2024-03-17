package com.recursion;

import java.util.Scanner;

public class PrintReverseOfString {
	public static void main(String args[]) {
		System.out.print("Enter the input string::");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		printReverseOfString(str, 0);	
	}

	private static void printReverseOfString(String str, int index) {
		if (index >= str.length()) {
			return;
		}		
		printReverseOfString(str, index + 1);
		System.out.print(str.charAt(index));
	}
}
