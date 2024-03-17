package com.matrix;

//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
public class SetMatrixZeroes {

	public static void main(String[] args) {

		int matrix[][] = { { 1, 1, 1 },
						   { 1, 0, 1 },
						   { 1, 1, 1 }
						 };

		int row[] = new int[matrix.length];
		int col[] = new int[matrix.length];

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix.length; j++) {

				if (matrix[i][j] == 0) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix.length; j++) {

				if (row[i] == 1 || col[j] == 1) {
					matrix[i][j] = 0;
				}
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
