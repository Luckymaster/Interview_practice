/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
*/

class Solution {
    
 	boolean[][] memo;

	int INF = Integer.MAX_VALUE;

	public int minPathSum(int[][] grid) {

		int row = grid.length;
		int column = grid[0].length;
		memo = new boolean[row][column];
		return traversre(grid, column, row, 0, 0, 0);
	}

	int traversre(int[][] grid, int column, int row, int r, int c, int sum) {

		if (r == row)
			return INF;
		if (c == column)
			return INF;

		if (memo[r][c]) {
			return grid[r][c];
		}

		if (r == row - 1 && c == column - 1) {
			memo[r][c] = true;
			return grid[r][c];
		}

		sum = grid[r][c]
				+ Math.min(traversre(grid, column, row, r + 1, c, sum), traversre(grid, column, row, r, c + 1, sum));
		grid[r][c] = sum;
		memo[r][c] = true;
		return sum;

	}
}
