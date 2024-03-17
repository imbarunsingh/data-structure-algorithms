package com.linkedlist.questions;

import com.linkedlist.common.Node;

import java.util.EmptyStackException;

class StackLinkedListImplementation {

	private Node top;
	
	private Node head;

	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	private void insertAtTail(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = top = newNode;
		} else {
			top.setNext(newNode);
			top = newNode;
		}		
		size++;
	}


	private int deleteAtTail() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		int removeNodeData = top.getData();
		Node currentNode = head;
		while (currentNode.getNext() != top) {
			currentNode = currentNode.getNext();			
		}
		top = currentNode;
		top.setNext(null);
		size--;
		return removeNodeData;
	}

	public void push(int data) {
		insertAtTail(data);
	}

	public int pop() {
		return deleteAtTail();
	}

	public void printStack() {
		if (isEmpty()) {
			System.out.println("[]");
			return;
		}
		Node currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode);
			currentNode = currentNode.getNext();
		}
	}

}

public class StackUsingLinkedList {
	public static void main(String[] args) {
		StackLinkedListImplementation stack = new StackLinkedListImplementation();

		System.out.println("----Assert push operation in stack::---------");
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.printStack();
		System.out.println("----------------------------------------------------");

		System.out.println("----Assert pop operation in stack::---------");
		int poppedElement = stack.pop();
		System.out.println(poppedElement);
		stack.printStack();
		System.out.println("----------------------------------------------------");

		System.out.println("----Assert push operation in stack::---------");
		stack.push(40);
		stack.printStack();
		System.out.println("----------------------------------------------------");
		
		System.out.println("----Assert pop operation in stack::---------");
		System.out.println(stack.pop());
		stack.printStack();
		System.out.println("----------------------------------------------------");

	}
}
