package com.recursion;

import java.util.Scanner;

//Refer Nishant Chahar/Babbar Youtube video for explanation
public class StringSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the source string you want to print all Subsequences ::");
		try (Scanner scanner = new Scanner(System.in)) {
			String  sourceString = scanner.nextLine();
			printSS(sourceString, "", 0);
		}
	}
	
	private static void printSS(String source, String response, int index) {
		if (index == source.length()) {
			System.out.println(response.toString());
			return;
		}	
		//take case
		printSS(source, response + source.charAt(index), index+1);
		//not take case
		printSS(source, response, index+1);
	}	

}
