/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
*/

class Solution {
    int tmp = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        return solveForMaxArea(grid,row,column);
    }
    int solveForMaxArea(int[][] grid,int row, int column){
        int maxArea = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j] ==1){
                    dfs(grid,i,j,row,column);
                    maxArea = Math.max(maxArea,tmp);
                    tmp = 0;
                }
            }
        }
        return maxArea;
    }
    
    void dfs(int[][] grid,int i, int j, int row, int column){
        
        if(i < 0 || i > row-1 || j < 0 || j > column-1) return;
        if(grid[i][j]!=1) return;
        if(grid[i][j] == 1){
            tmp+=1;
            grid[i][j] = 2;
        }
        dfs(grid, i-1,j,row,column);
        dfs(grid, i+1,j,row,column);
        dfs(grid, i,j-1,row,column);
        dfs(grid, i,j+1,row,column);
    }
}
