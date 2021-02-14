package com.queue;

public class SimpleArrayBasedQueue {

	public static void main(String[] args) {
		CustomQueue customQueue = new CustomQueue(4);
		customQueue.insert(10);
		customQueue.insert(20);
		customQueue.insert(30);
		customQueue.insert(40);
		customQueue.insert(70);
		
		customQueue.view();
		
		while(!customQueue.isEmpty()) {
			System.out.println(customQueue.remove());
		}
		System.out.println(customQueue.isEmpty());
	}

}

class CustomQueue {

	int maxSize;
	int queArray[];
	int front, rear;	

	public CustomQueue(int size) {
		super();
		this.maxSize = size;
		this.queArray = new int[maxSize];
		this.front = 0;
		this.rear = -1;		
	}

	public void insert(int data) {

		if (isFull()) {
			try {
				throw new Exception("The queue is full::");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		rear++;
		queArray[rear] = data;
	}

	public int remove() {
		int data=0;
		if (isEmpty()) {
			try {
				throw new Exception("The queue is empty");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			data = peek();
			front++;
		}				
		return data;
	}

	public boolean isEmpty() {
		return rear == -1 || rear == front - 1;
	}

	public boolean isFull() {
		return (rear == maxSize - 1);
	}

	public int peek() {
		if (isEmpty()) {			
			try {
				throw new Exception("The queue is empty::");
			} catch (Exception e) {
				System.out.println("Inside catch block");
				e.printStackTrace();				
			}
		}
		return queArray[front];
	}

	public void view() {
		for (int i = 0; i < queArray.length; i++) {
			System.out.print(queArray[i] + "  ");
		}
		System.out.println();
	}
}
