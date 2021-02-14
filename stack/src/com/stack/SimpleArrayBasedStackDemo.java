package com.stack;

import java.util.EmptyStackException;

public class SimpleArrayBasedStackDemo {
	public static void main(String[] args) {
		CustomStack stack = new CustomStack(7);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}		
	}
}

class CustomStack {
	int maxSize; // initializes the set number of slots
	int stackArray[];
	int top;

	public CustomStack(int size) {
		super();
		this.maxSize = size;
		this.stackArray = new int[maxSize];
		this.top = -1;
	}

	public void push(int data) {
		if (isFull()) {
			try {
				throw new StackOverflowError("The stack is Full");
			} catch (Exception e) {
				System.out.println("The stack is Full::");
			}
		}
		top++;
		stackArray[top] = data;

	}

	public int pop() {
		if (isEmpty()) {
			try {
				throw new EmptyStackException();
			} catch (Exception e) {
				System.out.println("The stack is empty::");
			}
		}
		int data = peek();
		stackArray[top] = Integer.MIN_VALUE;
		top--;
		return data;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize-1;
	}

	public int peek() {
		if (top == -1)
            throw new EmptyStackException();
		return stackArray[top];
	}	
}