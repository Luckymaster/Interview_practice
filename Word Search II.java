class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for(String word : words){
            int row = board.length;
            int column = board[0].length;
            if(Solver(board,row,column,word)){
                res.add(word);
            }
        }
        return res;

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
