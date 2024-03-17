package com.arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

//Refer Sumit Mallick 
//Time Complexity : O(nlogk)
//space complexity : O(k)

public class KthLargestElement {
	public static void main(String[] args) {
		int arr[] = {10,20,30,40,50,60,70};
		int k=3;
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(); // default is min heap queue
		
		for (int i = 0; i < arr.length; i++) {
			if(i < k) {
				queue.add(arr[i]);
			} else {
				if(arr[i] > queue.peek()) {
					queue.remove();
					queue.add(arr[i]);
				}
			}
		}
		if (!queue.isEmpty()) {
			System.out.print(k + "th largest element :: " + queue.peek());
		}
	}

}
