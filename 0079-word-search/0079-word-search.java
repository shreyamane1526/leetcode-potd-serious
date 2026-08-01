class Solution {
    int dx[]={0,0,1,-1};
    int dy[]={1,-1,0,0};
    boolean dfs(int i,int j,char board[][],String word,int idx,boolean pathVis[][],int n,int m,int len){
        if(idx+1==len){
            return true;
        }
        pathVis[i][j]=true;
        for(int k=0;k<4;k++){
            int newi=i+dx[k],newj=j+dy[k];
            if(newi>=0 && newj>=0 && newi<n && newj<m && !pathVis[newi][newj] && word.charAt(idx+1)==board[newi][newj]){              
                if(idx+1==len-1){
                    return true;
                }
                pathVis[newi][newj]=true;
                if(dfs(newi,newj,board,word,idx+1,pathVis,n,m,len)){
                    return true;
                }
                pathVis[newi][newj]=false;
            }
        }
        pathVis[i][j]=false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        int len=word.length();
        boolean pathVis[][]=new boolean[n][m];
        boolean flag=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){               
                if(board[i][j]==word.charAt(0) && dfs(i,j,board,word,0,pathVis,n,m,len)){
                    return true;
                }
            }
        }
        return flag;
    }
}