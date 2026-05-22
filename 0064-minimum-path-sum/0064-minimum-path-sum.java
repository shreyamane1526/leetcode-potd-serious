class Solution {
    int recur(int[][] grid,int m,int n,int i,int j,int sum){
        if(i==m-1 && j==n-1){
            sum+=grid[i][j];
            return sum;
        }
        int s1=Integer.MAX_VALUE,s2=Integer.MAX_VALUE;
        if(i+1<m){
            s1=recur(grid,m,n,i+1,j,sum+grid[i][j]);
        }
        if(j+1<n){
            s2=recur(grid,m,n,i,j+1,sum+grid[i][j]);
        }
        return Math.min(s1,s2);
    }
    int memoi(int[][] grid,int m,int n,int i,int j,int dp[][]){
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        int l=Integer.MAX_VALUE,r=Integer.MAX_VALUE;
        if(i+1<m){
            l=memoi(grid,m,n,i+1,j,dp);
        }
        if(j+1<n){
            r=memoi(grid,m,n,i,j+1,dp);
        }
        return dp[i][j]=grid[i][j]+Math.min(l,r);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        /*
        //recur
        return recur(grid,m,n,0,0,0);
        */
        
        //memoisation
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){ 
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return memoi(grid,m,n,0,0,dp);
    }
}