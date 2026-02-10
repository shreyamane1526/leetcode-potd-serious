class Solution {
    public static boolean solve(char[][] board){
        int[] pos=emptyPos(board);
        if(pos==null){
            return true;
        }
        int emptyx=pos[0],emptyy=pos[1];
        for(int i=0;i<9;i++){
            if(isValid(emptyx,emptyy,board,i+1)){            board[emptyx][emptyy]=(char)('0'+i+1);
                if(solve(board)){
                    return true;
                }
                board[emptyx][emptyy]='.';
            }
        }
        return false;
    }
    public static int[] emptyPos(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    public static boolean isValid(int x,int y,char[][] board,int num){
        for(int i=0;i<9;i++){
            if(board[x][i]!='.' && board[x][i]-'0'==num){
                return false;
            }
            if(board[i][y]!='.' && board[i][y]-'0'==num){
                return false;
            }
        }
        int r=(x/3)*3;
        int c=(y/3)*3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(board[i][j]!='.' && board[i][j]-'0'==num){
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
       // System.out.println(board);
    }
}