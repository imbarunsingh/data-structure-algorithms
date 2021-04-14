package com.queue;

import com.queue.exception.EmptyQueueException;

public class LinkedListQueue {
	public static void main(String[] args) {
		LinkedListBasedQueue customQueue = new LinkedListBasedQueue();
		customQueue.enQueue(10);
		customQueue.enQueue(20);
		customQueue.enQueue(30);
		customQueue.enQueue(40);
		customQueue.enQueue(70);

		System.out.println("Queue after enQueue Operations: ");
		customQueue.printQueue();

		customQueue.deQueue();

		System.out.println("Queue after deQueue Operations: ");
		customQueue.printQueue();

		System.out.println("Enqueue again :: ");
		customQueue.enQueue(50);
		customQueue.printQueue();

	}

}

class LinkedListBasedQueue {
	private Node head, tail;
	private int size;

	// Insert to the end of the list
	public void enQueue(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}

	// Remove from the beginning of the list
	public int deQueue() {
		if (isEmpty()) {
			throw new EmptyQueueException("The Queue is empty.");
		}
		int temp = head.getData();
		head = head.getNext();
		size--;
		return temp;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void printQueue() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}

}
