/*
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. 
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. 
Two cells are connected if they are adjacent cells connected horizontally or vertically.

[["X","X","X","X"],       
 ["X","O","O","X"],   
 ["X","X","O","X"],
 ["X","O","X","X"]
]

   |
   |
   V
[["X","X","X","X"],
["X","X","X","X"],
["X","X","X","X"],
["X","O","X","X"]]

*/

class SurroundedRegions {
    boolean [][] visited ;
    boolean seen = false;
    public void solve(char[][] board) {
        int row = board.length;
        int column = board[0].length;
        visited = new boolean[row][column];
        Solve(board,row,column);
    }
    void markVisited(char[][] board, int i, int j, int row, int column){
        if(i > row-1     || i < 0 || j > column-1 || j < 0  || board[i][j] == 'X')
            return;
        board[i][j] = 'X';
        markVisited(board,i-1,j,row,column);
        markVisited(board,i+1,j,row,column);
        markVisited(board,i,j-1,row,column);
        markVisited(board,i,j+1,row,column);
    }
    void dfsToReachEdge(char[][] board, int i, int j,int row, int column){
        if(i >= row || i < 0 || j >= column || j < 0 || visited[i][j] || board[i][j] == 'X') return;
        
        if(i <= 0 || i>=row-1 || j<= 0||j>=column-1) seen = true;
        visited[i][j] = true;
        dfsToReachEdge(board,i-1,j,row,column);
        dfsToReachEdge(board,i+1,j,row,column);
        dfsToReachEdge(board,i,j-1,row,column);
        dfsToReachEdge(board,i,j+1,row,column);
        
    }
    void Solve(char[][] board, int row, int column){
        for(int i=1;i<row-1;i++){
            for(int j=1;j<column-1;j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    seen = false;
                    dfsToReachEdge(board,i,j,row,column);
                    if(seen == false)
                        markVisited(board,i,j,row,column);
                    seen = true;
                }
            }
        }
    }
}
