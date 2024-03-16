package com.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Refer Babbar Youtube video for explanation
public class LetterCombinationPhone {

	public static void main(String[] args) {
		String mapping[] = {"", "", "abc", "def", "ghi", "jkl", "mno",  "pqrs", "tuv", "wxyz"};
		
		Map<Integer, Integer> map = new HashMap<>();
		
		// TODO Auto-generated method stub
		System.out.println("Enter the source digit ::");
		try (Scanner scanner = new Scanner(System.in)) {
			String  digit = scanner.nextLine();
			solve(digit, "", 0, mapping);
		}
	}
	
	private static void solve(String digit, String response, int index, String mapping[]) {
		if (index >= digit.length()) {
			System.out.println(response.toString());
			return;
		}	
		int number = digit.charAt(index) - '0';
		String value = mapping[number];
		
		for (int i = 0; i < value.length(); i++) {
			response = response + value.charAt(i);
			solve(digit, response, index + 1, mapping);
			//backtracking
			response = response.substring(0, response.length()-1);			
		}		
		
	}	

}
