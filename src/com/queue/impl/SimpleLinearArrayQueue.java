package com.queue.impl;

import com.queue.exception.EmptyQueueException;
import com.queue.exception.QueueOverflowException;

public class SimpleLinearArrayQueue {

	public static void main(String[] args) {
		LinearArrayQueue customQueue = new LinearArrayQueue(4);
		customQueue.enQueue(10);
		customQueue.enQueue(20);
		customQueue.enQueue(30);
		customQueue.enQueue(40);
		// customQueue.enQueue(70);

		System.out.println("Queue after enQueue Operations: ");
		customQueue.printQueue();

		customQueue.deQueue();

		System.out.println("Queue after deQueue Operations: ");
		customQueue.printQueue();
	}

}

class LinearArrayQueue {

	private int CAPACITY = 10;
	private int arr[];
	private int front = -1, rear = -1;
	private int size = 0;

	public LinearArrayQueue(int size) {
		this.CAPACITY = size;
		this.arr = new int[CAPACITY];
	}

	public LinearArrayQueue() {
		arr = new int[CAPACITY];
	}

	public void enQueue(int data) {
		if (isFull()) {
			throw new QueueOverflowException("The Queue is full.");
		}
		if (isEmpty()) {
			front++;
		}
		rear++;
		arr[rear] = data;
		size++;
	}

	public int deQueue() {
		int data;
		if (isEmpty()) {
			throw new EmptyQueueException("The queue is empty.");
		}
		data = peek();
		arr[front] = Integer.MIN_VALUE;
		front++;
		size--;
		return data;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == CAPACITY;
	}

	public int peek() {
		return arr[front];
	}

	public int size() {
		return size;
	}

	public void printQueue() {
		for (int i = 0; i < CAPACITY; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}
}
