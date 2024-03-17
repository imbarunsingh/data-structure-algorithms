package com.queue;

import com.queue.exception.EmptyQueueException;

public class DynamicCircularArrayQueue {
	public static void main(String[] args) {
		DynamicCircularArrayBasedQueue customQueue = new DynamicCircularArrayBasedQueue(4);
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

class DynamicCircularArrayBasedQueue {
	private int capacity = 10;
	private int arr[];
	private int front = -1, rear = -1;
	private int size = 0;

	/**
	 * The maximum size of array to allocate. Some VMs reserve some header words in
	 * an array. Attempts to allocate larger arrays may result in OutOfMemoryError:
	 * Requested array size exceeds VM limit
	 */
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	public DynamicCircularArrayBasedQueue(int size) {
		this.capacity = size;
		this.arr = new int[capacity];
	}

	public DynamicCircularArrayBasedQueue() {
		arr = new int[capacity];
	}

	public void enQueue(int data) {
		if (isFull()) {
			expand();
		}
		if (isEmpty()) {
			front++;
		}
		rear = (rear + 1) % capacity;
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
		front = (front + 1) % capacity;
		size--;
		if (size <= capacity / 4) {
			shrink();
		}
		return data;
	}

	public void expand() {
		capacity = capacity + capacity / 2; // Increase the arrays size by 50%: JDK 8 Rule
		int temp[] = arr;
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
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	public int peek() {
		return arr[front];
	}

	public int size() {
		return size;
	}

	public void printQueue() {
		for (int i = 0; i < capacity; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}
}
