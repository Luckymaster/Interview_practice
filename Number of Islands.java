/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

*/

class Solution {
    int numberOfisLand =0;
    public int numIslands(char[][] grid) {
        
        int row = grid.length;
        int column = grid[0].length; 
        DFS(grid,row,column);
        return numberOfisLand;
    }
    void markVisited(char[][] grid,int i, int j, int row, int column){
        if(i>=row || j>=column || i < 0 || j < 0  || grid[i][j]!='1') return;
        grid[i][j] = '2';
        markVisited(grid,i+1,j,row,column);
        markVisited(grid,i-1,j,row,column);
        markVisited(grid,i,j+1,row,column);
        markVisited(grid,i,j-1,row,column);
        
    }
    void DFS(char[][] grid,int row, int column){
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j] == '1'){
                    numberOfisLand+=1;
                    markVisited(grid,i,j,row,column);
                    
                }
            }
        }
    }
}
