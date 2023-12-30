package com.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Refer Nishant Chahar Youtube video for explanation
public class SubsetOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sourceArr[] = { 1, 2, 3 };

		printSS(sourceArr, new ArrayList<>(), 0);		
	}

	private static void printSS(int sourceArr[], List<Integer> responseList, int index) {
		if(index == sourceArr.length) {			
			System.out.println(responseList);			
			return;
		}
		// take case
		responseList.add(sourceArr[index]);
		printSS(sourceArr, responseList, index + 1);
		// not take case
		responseList.remove(responseList.size() - 1);
		printSS(sourceArr, responseList, index + 1);
	}

}
