class Solution {
    int recur(int m,int n,int i,int j){
        if(i==m-1 && j==n-1){
            return 1;
        }
        int l=0,r=0;
        if(i+1<m){ 
            l+=recur(m,n,i+1,j);
        }
        if(j+1<n){ 
            r+=recur(m,n,i,j+1);
        }
        return l+r;
    }
    int memoi(int m,int n,int i,int j,int dp[][]){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int l=0,r=0;
        if(i+1<m){ 
            l+=recur(m,n,i+1,j);
        }
        if(j+1<n){ 
            r+=recur(m,n,i,j+1);
        }
        return dp[i][j]=l+r;
    }
    public int uniquePaths(int m, int n) {
       // return recur(m,n,0,0);
       /*
       int dp[][]=new int[m][n];
       for(int i=0;i<m;i++){
        Arrays.fill(dp[i],-1);
       }
       return memoi(m,n,0,0,dp);
       */




       /* Tabulation
       int dp[][]=new int[m][n];
       dp[0][0]=1;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(i==0 && j==0){
                continue;
            }
            else if(i==0){
                dp[i][j]=dp[i][j-1];
            }
            else if(j==0){
                dp[i][j]=dp[i-1][j];
            }
            else{ 
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
       }
       return dp[m-1][n-1];



       */

        /*tabu with SO*/
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int prevCol=0;
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                prevCol=prevCol+dp[j];
                dp[j]=prevCol;
            }
            prevCol=0;
        }
        return dp[n-1];
    }
}