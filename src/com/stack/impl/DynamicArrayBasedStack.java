package com.stack.impl;

public class DynamicArrayBasedStack {
	public static void main(String[] args) {
		DynamicArrayStack stack = new DynamicArrayStack(3);

		System.out.println("----Push Operation::------");
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.printStack();
		System.out.println("stack size : " + stack.size());

		System.out.println("----Pop Operation::------");
		stack.pop();
		stack.pop();
		stack.pop();
		stack.printStack();
		System.out.println("stack size : " + stack.size());
	}

}

class DynamicArrayStack {
	private int arr[];
	private int top = -1;
	private int capacity = 10;

	public DynamicArrayStack(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
	}

	public DynamicArrayStack() {
		arr = new int[capacity];
	}

	public void push(int data) {
		// Check if the array is full
		if (top == capacity - 1) {
			expand();
		}
		top++;
		arr[top] = data;
	}

	public int pop() {
		int temp = arr[top];
		top--;
		if (top + 1 <= capacity / 4) { // When the no of elements is 25 % of actual array size
			shrink();
		}
		return temp;
	}

	public void expand() {
		int temp[] = arr;
		capacity = capacity + capacity / 2; // Increases the arrays size by 50%: JDK 8 Rule
		arr = new int[capacity];
		System.arraycopy(temp, 0, arr, 0, temp.length);
	}

	public void shrink() {
		int temp[] = arr;
		capacity = capacity / 2; // Reduces the array size by half
		arr = new int[capacity];
		System.arraycopy(temp, 0, arr, 0, capacity);
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == capacity - 1;
	}

	public void printStack() {
		for (int i = 0; i <= top; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public int size() {
		return top + 1;
	}

}
