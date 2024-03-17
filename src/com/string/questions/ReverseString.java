package com.string.questions;

public class ReverseString {

	public static void main(String[] args) {
		String str = "arnold";
		
		String resultString = reverseStringInplace(str);
		System.out.println(resultString);
		
	}
	
	public static String reverseStringWithThirdVariable(String sourceString) {
		String reversedString = "";
		
		for (int i = sourceString.length() - 1; i >= 0 ; i--) {
			reversedString += sourceString.charAt(i);			
		}
		return reversedString;
	}
	
	public static String reverseStringInplace(String sourceString) {
		char sourceStringArr[] = sourceString.toCharArray();
		
		int start = 0; 
		int end = sourceString.length() - 1;
				
		while (start < end) {
			swap(sourceStringArr, start, end);
			start++;
			end--;
		}
		sourceString = "";
		for (char c : sourceStringArr) {
			sourceString +=c;
		}
		return sourceString;
	}
	
	private static void swap(char sourceString[], int start, int end) {
		char third = sourceString[start];
		sourceString[start] = sourceString[end];
		sourceString[end] = third;
	}

}
