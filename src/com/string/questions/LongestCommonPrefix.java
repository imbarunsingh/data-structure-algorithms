package com.string.questions;


//Time complexity : O(m*N) where m is the max character in N Strings
//Can also be solved by Trie but has more space complexity
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String strArr[] = {"carolina", "caroma", "car"};
		String lcpString = getLongestCommonPrefix(strArr);
		
		System.out.println("Longest Common Prefix :: " + lcpString);

	}
	
	public static String getLongestCommonPrefix(String strArr[]) {
		String longestCommonPrefix = "";
		
		if (strArr == null || strArr.length == 0) {
			return longestCommonPrefix;
		}	
		
		int index = 0;		
		
		for (char c : strArr[0].toCharArray()) {
			
			for (int i = 1; i < strArr.length; i++) {
				
				if(index >= strArr[i].length() || c != strArr[i].charAt(index)) {
					return longestCommonPrefix;
				}				
			}
			longestCommonPrefix += c;
			index++;			
		}		
		return longestCommonPrefix;		
	}

}
