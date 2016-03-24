package leetcoder.sch.HashTable;

public class ValidSoduku {
	/*
	 * URL: https://leetcode.com/problems/valid-sudoku/
	 * Result: Accepted
	 * Time: O(n^2), Memory: O(n^2)
	 * Explain:
	 * 		We create 3 kinds of hash table:
	 * 		~~~hashHorizonal: stores elements in same horizontal
	 * 		~~~hashVertical: stores elements in same vertical 
	 * 		~~~hashGrid: stores elements in same small grid
	 * 		
	 * 		for every element, we check horizontally, vertically, and "gridly"
	 * 	if one of these fail, we know it breaks sudoku rules. Specially, we use 
	 * 	an integer to represent a hash table, and bit operations for hash 
	 */
	public static boolean isValidSudoku( char[][] board ) {
		
		int[] hashHorizonal = new int[9];
		int[] hashVertical = new int[9];
		int[] hashGrid = new int[9];
		
		int m = board.length;
		for( int i = 0; i < m; ++i ) {
			for( int j = 0; j < m; ++j ) {
				char ch = board[i][j];
				if( ch == '.' ) continue;
				int chValue = ch - '0';
				if( exists(hashHorizonal, i, chValue) ) return false;
				if( exists(hashVertical, j, chValue) ) return false;
				if( exists(hashGrid, (i/3)*3+j/3, chValue) ) return false;
			}
		}
		return true;
	}
	private static boolean exists( int[] nums, int i, int val ) {
		if( (nums[i]&(1<<val)) != 0 ) {
			return true;
		} else {
			nums[i] |= (1<<val);
			return false;
		}
	}
}
