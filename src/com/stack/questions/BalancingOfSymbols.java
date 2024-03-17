package com.stack.questions;

import java.util.*;

public class BalancingOfSymbols {
	public static void main(String args[]) {
		
		Stack<Object> stack = new Stack<>();

		System.out.println("Enter the symbols input::");
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();

		Boolean isBalanced = null;

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '[') {
				stack.push('[');
			} else if (text.charAt(i) == '{') {
				stack.push('{');
			} else if (text.charAt(i) == '(') {
				stack.push('(');
			}

			else if (text.charAt(i) == ']') {
				if ((char)stack.pop() != '[') {
					isBalanced = false;
					break;
				}
			}
			else if(text.charAt(i) == '}') {
				if ((char)stack.pop() != '{') {
					isBalanced = false;
					break;
				}
				
			} else if(text.charAt(i) == ')') {
				if ((char)stack.pop() != '(') {
					isBalanced = false;
					break;
				}
			}
				
		}
		if (isBalanced == null && stack.isEmpty()) {
			isBalanced = true;
		}

		System.out.println("The symbols are balanced :: " + isBalanced);

	}
}

