package com.stack.impl;

import java.util.EmptyStackException;

public class SimpleArrayBasedStack {
	public static void main(String[] args) {
		ArrayBasedStack stack = new ArrayBasedStack(7);

		System.out.println("----Push Operation::------");
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.printStack();

		System.out.println("----Pop Operation::------");
		System.out.println(stack.pop());
		stack.printStack();
	}
}

class ArrayBasedStack {
	int arr[];
	int top;

	public ArrayBasedStack(int capacity) {
		this.arr = new int[capacity];
		this.top = -1;
	}

	public void push(int data) {
		if (isFull()) {
			throw new StackOverflowError("The stack is Full");
		}
		top++;
		arr[top] = data;

	}

	public int pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		int data = arr[top];
		arr[top] = Integer.MIN_VALUE;
		top--;
		return data;
	}

	public void printStack() {
		for (int i = 0; i <= top; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return (top + 1) == arr.length;
	}
}