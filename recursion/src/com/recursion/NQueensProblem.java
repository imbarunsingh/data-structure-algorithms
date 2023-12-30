package com.recursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Time Complexity: O(N!)
//Auxiliary Space: O(N2)

public class NQueensProblem {
	public static void main(String[] args) {
		NQueensProblem nQueensProblem = new NQueensProblem();
		List<List<String>> allBoardsList = nQueensProblem.solveNQueens(4);
		System.out.println(allBoardsList);
	}
	
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> allBoardsList= new ArrayList<>();
		char[][] board = new char[n][n];
		helper(board, allBoardsList, 0);
		return allBoardsList;
	}

	// A recursive utility function to solve N Queen problem
	private void helper(char[][] board, List<List<String>> allBoardsList, int col) {
		// Base case: If all queens are placed
		// then return true
		if(col == board.length) {
			//saving the solution
			saveBoard(board, allBoardsList);
			return;
		}
		
		// Consider this column and try placing
		// this queen in all rows one by one
		for (int i = 0; i < board.length; i++) {
			// Check if the queen can be placed on
			// board[row][col]
			if(isSafe(i, col, board)) {
				// Place this queen in board[i][col]
				board[i][col] = 'Q';
				// Recur to place rest of the queens
				helper(board, allBoardsList, col + 1);
				// If placing queen in board[row][col]
				// doesn't lead to a solution then
				// remove queen from board[row][col]
				board[i][col] = '.'; // BACKTRACK
			}
		}		
	}
	//Saves all possible solution to a list of list in a format
	private void saveBoard(char[][] board, List<List<String>> allBoardsList) {
		// TODO Auto-generated method stub
		List<String> newBoard = new ArrayList<>();
		String row = "";
		for (int i = 0; i < board.length; i++) {
			row = "";
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == 'Q') {
					row = row + "Q";
				} else {
					row = row + ".";
				}
			}
			newBoard.add(row);
		}
		allBoardsList.add(newBoard);
	}

	// A utility function to check if a queen can
    // be placed on board[row][col]. Note that this
    // function is called when "col" queens are already
    // placed in columns from 0 to col -1. So we need
    // to check only left side for attacking queens
	private static boolean isSafe(int row, int col, char[][] board) {
		int i, j;
		// Check this row on left side
		for (i = 0; i < col; i++) {
			if (board[row][i] == 'Q')
				return false;
		}
		// check diagonal
		// Check upper diagonal on left side
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q')
				return false;
		}
		// Check lower diagonal on left side
		for (i = row, j = col; j >= 0 && i < board.length; i++, j--) {
			if (board[i][j] == 'Q')
				return false;
		}
		return true;
	}

}
