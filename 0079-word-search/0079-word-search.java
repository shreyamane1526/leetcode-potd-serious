class Solution {
    int dx[]={0,0,1,-1};
    int dy[]={1,-1,0,0};
    boolean dfs(int i,int j,char board[][],String word,int idx,int n,int m,int len){
        if(idx+1==len){
            return true;
        }
        char ch=board[i][j];
        board[i][j]='.';
        for(int k=0;k<4;k++){
            int newi=i+dx[k],newj=j+dy[k];
            if(newi>=0 && newj>=0 && newi<n && newj<m  && word.charAt(idx+1)==board[newi][newj]){              
                if(idx+1==len-1){
                    return true;
                }
                char c=board[newi][newj];
                board[newi][newj]='.';
                if(dfs(newi,newj,board,word,idx+1,n,m,len)){
                    return true;
                }
                board[newi][newj]=c;
            }
        }
        board[i][j]=ch;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        int len=word.length();
        boolean flag=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){               
                if(board[i][j]==word.charAt(0) && dfs(i,j,board,word,0,n,m,len)){
                    return true;
                }
            }
        }
        return flag;
    }
}