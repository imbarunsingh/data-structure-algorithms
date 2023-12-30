package com.recursion;

import java.util.*;

public class PalindromeOfString {
	public static void main(String args[]) {
		System.out.print("Enter teh source string::");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean isPalindrome =  isPalindrome(str, 0, str.length()-1);
		if(isPalindrome) {
			System.out.print("It's a palindrome::");
		} else {
			System.out.print("Not a palindrome::");
		}

	}

	private static boolean isPalindrome(String str, int startIndex, int endIndex) {
		if(startIndex >= endIndex) {
			return true;
		}
		if (str.charAt(startIndex) == str.charAt(endIndex)) {
			isPalindrome(str, startIndex + 1, endIndex - 1);
		} else {
			return false;
		}
		return true;
	}
}
