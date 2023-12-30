package com.linkedlist.questions;

import com.linkedlist.EmptyLinkedListException;
import com.linkedlist.Node;
import com.linkedlist.singly.SinglyLinkedList;

class FloydCycleAlgorithmImpl {

	public boolean hasLoop(Node head) {
		if (head == null) {
			throw new EmptyLinkedListException("Empty Linked List Exception");
		}
		Node slowPointer = head;
		Node fastPointer = head;

		while (fastPointer != null && fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext(); //2x the speed of slow pointer
			
			if (slowPointer == fastPointer) {
				return true;
			}
		}
		return false;
	}

	public Node findBeginingOfLoop(Node head) {
		if (head == null) {
			throw new EmptyLinkedListException("Empty Linked List Exception");
		}
		boolean hasLoop = false;
		Node slowPointer = head;
		Node fastPointer = head;

		while (fastPointer != null && fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();

			if (slowPointer == fastPointer) {
				hasLoop = true;
				break;
			}
		}

		if (hasLoop) {
			slowPointer = head;
			while (slowPointer != fastPointer) {
				slowPointer = slowPointer.getNext();
				fastPointer = fastPointer.getNext();
			}
			return slowPointer;

		}
		return null;
	}

	public int getLoopLength(Node head) {
		if (head == null) {
			throw new EmptyLinkedListException("Empty Linked List Exception");
		}
		boolean hasLoop = false;
		Node slowPointer = head;
		Node fastPointer = head;

		while (fastPointer != null && fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();

			if (slowPointer == fastPointer) {
				hasLoop = true;
				break;
			}

		}

		if (hasLoop) {
			int length = 1;
			while (slowPointer.getNext() != fastPointer) {
				slowPointer = slowPointer.getNext();
				length++;
			}
			return length;
		} else {
			throw new EmptyLinkedListException("The linked list does not have loop.");
		}
	}

	public void findAndTerminateLoop(Node head) {
		if (head == null) {
			throw new EmptyLinkedListException("Empty Linked List Exception");
		}
		boolean hasLoop = false;
		Node slowPointer = head;
		Node fastPointer = head;

		while (fastPointer != null && fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();

			if (slowPointer == fastPointer) {
				hasLoop = true;
				break;
			}
		}
		if (hasLoop) {
			slowPointer = head;
			while (slowPointer != fastPointer) {
				slowPointer = slowPointer.getNext();

				if (fastPointer.getNext() == slowPointer) {
					fastPointer.setNext(null);
					break;
				}
				fastPointer = fastPointer.getNext();

			}
		}
	}
}

public class FloydCycleAlgorithm {
	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.insertAtEnd(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.printList();
		System.out.println("----------------------------------------------------");

		FloydCycleAlgorithmImpl floydCycleAlgorithm = new FloydCycleAlgorithmImpl();

		System.out.println("--Asserting the LinkedList when there is no Loop--");
		System.out.println("Does linked list has loop:: " + floydCycleAlgorithm.hasLoop(linkedList.getHead()));
		System.out.println("-------------------------------------------------------");

		System.out.println("--Asserting the hasLoop when there is a Loop--");
		linkedList.getTail().setNext(linkedList.getHead().getNext().getNext());
		System.out.println("Does linked list has loop:: " + floydCycleAlgorithm.hasLoop(linkedList.getHead()));
		System.out.println("-------------------------------------------------------");

		System.out.println("--Asserting findBeginingOfLoop-----");
		System.out
				.println("The loop begins at Node :: " + floydCycleAlgorithm.findBeginingOfLoop(linkedList.getHead()));
		System.out.println("-------------------------------------------------------");

		System.out.println("--Asserting getLoopLength-----");
		System.out.println("The loop length is :: " + floydCycleAlgorithm.getLoopLength(linkedList.getHead()));
		System.out.println("-------------------------------------------------------");

		System.out.println("--Asserting findAndTerminateLoop-----");
		floydCycleAlgorithm.findAndTerminateLoop(linkedList.getHead());
		System.out.println("Does linked list has loop now:: " + floydCycleAlgorithm.hasLoop(linkedList.getHead()));
		System.out.println("-------------------------------------------------------");
	}

}
