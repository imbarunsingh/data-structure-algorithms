package com.linkedlist.doubly;

//Linked List class structure for doubly linked list
public class DLLNode {

	private int data;
	private DLLNode next;
	private DLLNode previous;

	public DLLNode() {}
	
	public DLLNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	public DLLNode getPrevious() {
		return previous;
	}

	public void setPrevious(DLLNode previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}	
}
