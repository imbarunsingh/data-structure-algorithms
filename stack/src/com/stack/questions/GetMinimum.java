package com.stack.questions;

import java.util.Stack;

public class GetMinimum {
	public static void main(String[] args) {
		GetMinimumImpl getMinimumImpl = new GetMinimumImpl();
		getMinimumImpl.push(10);
		getMinimumImpl.push(20);
		getMinimumImpl.push(2);
		getMinimumImpl.push(8);
		getMinimumImpl.push(15);

		getMinimumImpl.printStack();

		System.out.println("Minimumnm element in the stack :: " + getMinimumImpl.getMinimun());
	}
}

class GetMinimumImpl {
	Stack<Integer> elementStack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	public void push(int data) {
		if (minStack.isEmpty() || data < minStack.peek()) {
			minStack.push(data);
		}
		elementStack.push(data);
	}

	public void pop() {
		if (elementStack.peek() == minStack.peek()) {
			minStack.pop();
		}
		elementStack.pop();
	}

	public int getMinimun() {
		return minStack.peek();
	}

	public void printStack() {
		System.out.println(elementStack);
	}
}
