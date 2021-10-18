/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        return Solver(board,row,column,word);
    }
    boolean Solver(char[][] board, int row, int column, String word){
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(word.charAt(0) == board[i][j]){
                    boolean res = dfs(board,i, j, row, column,word,0);
                    if(res) return true;
                }
            }
        }
        return false;
    }
    
    boolean dfs(char[][] board, int i, int j, int row, int column, String word, int d){
        int ln = word.length();
        
        if(d == ln) return true;
    
        if(i < 0 || i >row-1 || j < 0 || j > column-1) return false;
        if(board[i][j] == word.charAt(d)){
            char tmp = board[i][j];
            board[i][j] = '#';
            boolean res = dfs(board,i-1,j,row,column,word,d+1)||
                 dfs(board,i+1,j,row,column,word,d+1)||
                 dfs(board,i,j-1,row,column,word,d+1)||
                 dfs(board,i,j+1,row,column,word,d+1);
            board[i][j] = tmp;
            return res;
            
        }else{
            return false;
        }
        
    }
}
