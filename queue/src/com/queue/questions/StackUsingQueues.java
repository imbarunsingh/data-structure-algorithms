package com.queue.questions;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
	public static void main(String[] args) {
		StackUsingTwoQueues stackUsingTwoQueues = new StackUsingTwoQueues();
		stackUsingTwoQueues.push(10);
		stackUsingTwoQueues.push(20);
		stackUsingTwoQueues.push(30);

		stackUsingTwoQueues.printQueue();

		stackUsingTwoQueues.pop();
		
		stackUsingTwoQueues.printQueue();

		stackUsingTwoQueues.push(40);
		stackUsingTwoQueues.push(50);
		stackUsingTwoQueues.push(60);
		
		stackUsingTwoQueues.pop();

		stackUsingTwoQueues.printQueue();

	}

}

class StackUsingTwoQueues {
	private Queue<Object> queue1;
	private Queue<Object> queue2;

	public StackUsingTwoQueues() {
		this.queue1 = new LinkedList<Object>();
		this.queue2 = new LinkedList<Object>();
	}

	public void push(Object data) {
		if (queue1.isEmpty() && queue2.isEmpty()) {
			queue1.add(data);
			return;
		}

		if (queue1.isEmpty()) {
			queue2.add(data);
		} else {
			queue1.add(data);
		}
	}

	public Object pop() {
		int size, i = 0;
		if (queue2.isEmpty()) {
			size = queue1.size();
			while (i < size - 1) {
				queue2.add(queue1.remove());
				i++;
			}
			return queue1.remove();
		} else if (queue1.isEmpty()) {
			size = queue2.size();
			while (i < size - 1) {
				queue1.add(queue2.remove());
				i++;
			}
			return queue2.remove();

		}
		return null;
	}

	public void printQueue() {
		if (!queue1.isEmpty()) {
			System.out.println(queue1);
		} else if (!queue2.isEmpty()) {
			System.out.println(queue2);
		}
	}

}
