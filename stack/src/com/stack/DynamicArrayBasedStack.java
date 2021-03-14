package com.stack;

public class DynamicArrayBasedStack {
	public static void main(String[] args) {
		DynamicArrayStack stack = new DynamicArrayStack(3);

		System.out.println("----Push Operation::------");
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.printStack();
		System.out.println("stack size : "+stack.size());
		

		System.out.println("----Pop Operation::------");
		stack.pop();
		stack.pop();
		stack.pop();
		stack.printStack();
		System.out.println("stack size : "+stack.size());
	}

}

class DynamicArrayStack {
	int arr[];
	int top = -1;

	public DynamicArrayStack(int capacity) {
		arr = new int[capacity];
	}

	public void push(int data) {
		// Check if the array is full
		if (top == arr.length - 1) {
			expand();
		}
		top++;
		arr[top] = data;
	}

	public int pop() {
		int temp = arr[top];
		top--;
		if (top+1 < (arr.length) / 2) {
			shrink();
		}
		return temp;
	}

	public void expand() {
		int temp[] = arr;
		int newCapacity = arr.length * 2;
		arr = new int[newCapacity];
		System.arraycopy(temp, 0, arr, 0, temp.length);
	}

	public void shrink() {
		int temp[] = arr;
		int newCapacity = arr.length/2;
		arr = new int[newCapacity];
		System.arraycopy(temp, 0, arr, 0, arr.length);
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == arr.length - 1;
	}
	
	public void printStack() {
		for (int i = 0; i <= top; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public int size() { 
		return arr.length;
	}

}
