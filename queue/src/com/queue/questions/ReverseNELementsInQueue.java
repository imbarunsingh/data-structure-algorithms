package com.queue.questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseNELementsInQueue {
	public static void main(String[] args) {

		Queue<Object> queue = new LinkedList<Object>();
		Stack<Object> stack = new Stack<Object>();

		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);
		queue.add(70);
		queue.add(80);
		queue.add(90);

		System.out.println("Original Queue :: " + queue);

		int i = 0, n = 4;

		// Push the first n elements to a stack
		while (i < n) {
			stack.push(queue.remove());
			i++;
		}

		// Pop the element from stack and add back to queue so that the first n elements
		// are reversed
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}

		// Re-arrange the queue to get the order after reversal of first n elements
		for (int j = 0; j < queue.size() - n; j++) {
			queue.add(queue.remove());
		}

		System.out.println("Queue after Reversing the first " + n + " elements :: " + queue);

	}

}
