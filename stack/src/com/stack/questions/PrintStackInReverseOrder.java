package com.stack.questions;

import java.util.*;

public class PrintStackInReverseOrder {
	public static void main(String args[]) {

		PrintStackInReverseOrderImpl impl = new PrintStackInReverseOrderImpl();

		// push element to stack
		impl.push(10);
		impl.push(20);
		impl.push(30);
		impl.push(55);
		impl.push(60);

		impl.reverseStack(impl.getStack());
	}
}

class PrintStackInReverseOrderImpl {

	Stack<Object> stack = new Stack<Object>();

	public void push(Object data) {
		stack.push(data);
	}

	public void reverseStack(Stack<Object> stack) {
		// Base condition
		if (stack.isEmpty()) {
			return;
		}
		Object data = stack.pop();
		reverseStack(stack);
		System.out.print(data + " ");
	}

	public Stack<Object> getStack() {
		return stack;
	}

}
