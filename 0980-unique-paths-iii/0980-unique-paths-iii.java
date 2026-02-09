class Solution {
    int helper(int n,int m,int curRow,int curCol,int c,int grid[][]){
        int ans=0;
        if(grid[curRow][curCol]==2){
            if(c==0){
                return 1;
            }
            return 0;
        }
        int temp=grid[curRow][curCol];
        grid[curRow][curCol]=-1;       
        int dxy[][]={{0,1},{0,-1},{1,0},{-1,0}};
        for(int k=0;k<4;k++){
            int dx=curRow+dxy[k][0],dy=curCol+dxy[k][1];
            if(dx>=0 && dx<n && dy>=0 && dy<m && grid[dx][dy]==0){
                ans+=helper(n,m,dx,dy,c-1,grid);
            }
            else if(dx>=0 && dx<n && dy>=0 && dy<m && grid[dx][dy]==2){
                ans+=helper(n,m,dx,dy,c,grid);
            }
        }
        grid[curRow][curCol]=temp;
        return ans;
    }
    public int uniquePathsIII(int[][] grid) {
        int c=0,startRow=0,startCol=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    startRow=i;startCol=j;
                }
                else if(grid[i][j]==0){
                    c++;
                }
            }
        }
        return helper(n,m,startRow,startCol,c,grid);
    }
}