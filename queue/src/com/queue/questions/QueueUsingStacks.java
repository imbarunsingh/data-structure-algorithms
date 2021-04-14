package com.queue.questions;

import java.util.Stack;

public class QueueUsingStacks {

	public static void main(String[] args) {

		QueueUsingTwoStacks queueUsingTwoStacks = new QueueUsingTwoStacks();

		queueUsingTwoStacks.enQueue(10);
		queueUsingTwoStacks.enQueue(20);
		queueUsingTwoStacks.enQueue(30);

		queueUsingTwoStacks.printQueue();

		queueUsingTwoStacks.deQueue();

		queueUsingTwoStacks.enQueue(40);
		queueUsingTwoStacks.enQueue(50);

		queueUsingTwoStacks.printQueue();

	}

}

class QueueUsingTwoStacks {
	Stack<Object> stack1 = new Stack<Object>();
	Stack<Object> stack2 = new Stack<Object>();

	public void enQueue(int data) {
		stack1.push(data);
	}

	public Object deQueue() {
		if (!stack2.isEmpty()) {
			return stack2.pop();
		}

		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}

	public void printQueue() {
		if (!stack2.isEmpty()) {
			System.out.println(stack2);
		}
		if (!stack1.isEmpty()) {
			System.out.print(stack1);
		}
		System.out.println();
	}
}
