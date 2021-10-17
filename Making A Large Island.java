/*
You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

 

Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 500
grid[i][j] is either 0 or 1.

*/


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {

	boolean changed = false;
	int largest = 0;
	int tmp = 0;
	Map<Integer, Integer> idAndLength;
	int allOnes = 0;

	public int largestIsland(int[][] grid) {
		int row = grid.length;
		idAndLength = new HashMap<>();
		idAndLength.put(0, 0);
		int column = grid[0].length;
		boolean[][] visited = new boolean[row][column];
		clear(row, column, grid, visited);
		if (allOnes == row * row)
			return allOnes;
		if (allOnes < 2)
			return allOnes + 1;
		Solve(grid, row, column, visited);
		return largest;
	}

	void clear(int row, int column, int[][] grid, boolean[][] visited) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				visited[i][j] = false;
				allOnes += grid[i][j];
			}
		}
	}

	int getIsLandSize(int[][] grid, int i, int j, int row, int column) {
		if (i < 0 || i > row - 1 || j < 0 || j > column - 1)
			return 0;
		else
			return grid[i][j];
	}

	void Solve(int[][] grid, int row, int column, boolean[][] visited) {
		int id = 2;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (grid[i][j] == 1) {
					DFS(grid, i, j, row, column, visited, id);
					idAndLength.put(id, tmp);
					id += 1;
					tmp = 0;
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (grid[i][j] == 0) {
					int len = 1;
					Set<Integer> combineIsLand = new HashSet<>();
					combineIsLand.add(getIsLandSize(grid, i - 1, j, row, column));
					combineIsLand.add(getIsLandSize(grid, i + 1, j, row, column));
					combineIsLand.add(getIsLandSize(grid, i, j - 1, row, column));
					combineIsLand.add(getIsLandSize(grid, i, j + 1, row, column));

					for (Integer o_o : combineIsLand) {
						len += idAndLength.get(o_o);
						largest = Math.max(largest, len);
					}
				}
			}
		}
	}

	void DFS(int[][] grid, int i, int j, int row, int column, boolean[][] visited, int id) {
		if (i < 0 || i > row - 1 || j < 0 || j > column - 1)
			return;
		if (visited[i][j] || grid[i][j] == 0)
			return;
		if (grid[i][j] == 1) {
			grid[i][j] = id;
			tmp += 1;
		}
		visited[i][j] = true;
		DFS(grid, i - 1, j, row, column, visited, id);
		DFS(grid, i + 1, j, row, column, visited, id);
		DFS(grid, i, j + 1, row, column, visited, id);
		DFS(grid, i, j - 1, row, column, visited, id);
	}
