package com.recursion;

/*
 * Time Complexity: T(n) = T(n-1) + T(n-1) + c
 * T(n) = 2T(n-1) + c 
	O(2 power n)
 */
public class TowerOfHanoi {
	public static void main(String[] args) {
		int n = 3; // Number of disks
		towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods : A is the source , C destination and B is
										// auxiliary
	}

	private static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
		if (n == 1) {
			System.out.println("Move disc 1 from rod : " + from_rod + " to rod : " + to_rod);
			return;
		}
		towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
		System.out.println("Move disc " + n + " from rod: " + from_rod + " to rod: " + to_rod);
		towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
	}
}
