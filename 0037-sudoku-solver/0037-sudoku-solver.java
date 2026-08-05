class Solution {
    boolean isSafe(int r,int c,char[][] board,char ch){
        for(int i=0;i<9;i++){
            if(board[r][i]==ch){
                return  false;
            }
            if(board[i][c]==ch){
                return false;
            }
            int a=3*(r/3)+i/3;
            int b=3*(c/3)+i%3;
            if(board[a][b]==ch){
                return false;
            }
        }
        return true;
    }
    boolean backtrack(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){                       
                        if(isSafe(i,j,board,k)){
                            board[i][j]=k;
                            if(backtrack(board)){
                                return true;
                            }                          
                            board[i][j]='.';
                        }
                        
                    }
                    return false;
                }
            }
        }
        return true;
        
    }
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
}