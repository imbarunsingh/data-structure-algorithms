package com.queue.questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseAQueue {

	public static void main(String[] args) {
		Queue<Object> queue = new LinkedList<Object>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);

		// queue.remove();

		System.out.println("Original Queue : ");
		System.out.println(queue + "\n");

		QueueReversal queueReversal = new QueueReversal();
		queueReversal.reverseQueue(queue);

		System.out.println("Reversed Queue : ");
		System.out.println(queue);
	}

}

class QueueReversal {
	Stack<Object> stack = new Stack<Object>();

	public void reverseQueue(Queue<Object> queue) {

		while (!queue.isEmpty()) {
			stack.push(queue.remove());
		}

		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
	}
}
