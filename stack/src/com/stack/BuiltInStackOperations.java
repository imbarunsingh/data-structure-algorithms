package com.stack;

import java.util.Stack;

public class BuiltInStackOperations {
	public static void main(String[] args) {
		
		Stack<Integer> integerStack = new Stack<Integer>();
		
		integerStack.push(10);
		integerStack.push(20);
		integerStack.push(30);
		integerStack.push(40);
		
		System.out.println("Poping:"+integerStack.pop());
		
		for(Integer s : integerStack) {
			System.out.println(s);
		}
		
		
	}

}
