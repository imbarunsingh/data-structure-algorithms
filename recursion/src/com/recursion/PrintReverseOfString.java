package com.recursion;

import java.util.Scanner;

public class PrintReverseOfString {
	public static void main(String args[]) {
		System.out.print("Enter the input string::");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		printReverseOfString(str, str.length() - 1);	
	}

	private static void printReverseOfString(String str, int index) {
		if (index < 0) {
			return;
		}
		System.out.print(str.charAt(index));
		printReverseOfString(str, index - 1);
	}
}
