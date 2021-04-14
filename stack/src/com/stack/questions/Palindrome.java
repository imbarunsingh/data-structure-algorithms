package com.stack.questions;

import java.util.Scanner;
import java.util.Stack;

import javax.imageio.event.IIOReadProgressListener;

public class Palindrome {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string for palindrome check: ");
		String inputString = scanner.nextLine();
		scanner.close();

		PalindromeUtil palindromeUtil = new PalindromeUtil();
		boolean isPalindrome = palindromeUtil.isPalindrome(inputString);
		if (isPalindrome) {
			System.out.println("The input string is a palindrome !");
		} else {
			System.out.println("The input string is NOT a palindrome !");
		}

	}

}

class PalindromeUtil {
	private Stack<Character> stack = new Stack<Character>();

	public boolean isPalindrome(String str) {
		char charArray[] = str.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			if (i < charArray.length / 2) {
				stack.push(charArray[i]);
			} else if (i > charArray.length / 2) {
				if (stack.peek() == charArray[i]) {
					stack.pop();
				} else {
					return false;
				}
			}

		}
		return true;
	}
}
