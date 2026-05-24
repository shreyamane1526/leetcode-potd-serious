class Solution {
    int recur(int[][] matrix,int i,int j,int n){
        if(i==n-1){
            return matrix[i][j];
        }
        int ld=Integer.MAX_VALUE,rd=ld,d=ld;
        if(j-1>=0){ld=matrix[i][j]+recur(matrix,i+1,j-1,n);}
        d=matrix[i][j]+recur(matrix,i+1,j,n);
        if(j+1<n){rd=matrix[i][j]+recur(matrix,i+1,j+1,n);}
        return Math.min(ld,Math.min(rd,d));
    }
    int memoi(int[][] matrix,int i,int j,int n,int dp[][]){
        if(i==n-1){
            return matrix[i][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        int ld=Integer.MAX_VALUE,rd=ld,d=ld;
        if(j-1>=0){ld=matrix[i][j]+recur(matrix,i+1,j-1,n);}
        d=matrix[i][j]+recur(matrix,i+1,j,n);
        if(j+1<n){rd=matrix[i][j]+recur(matrix,i+1,j+1,n);}
        return dp[i][j]=Math.min(ld,Math.min(rd,d));
    }
    int tabu(int[][] matrix,int n,int dp[][]){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(i==0){
                    dp[0][j]=matrix[0][j];
                }
                else{
                    if(j==0){
                        dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
                    }
                    else if(n-1!=j){
                        int ld=matrix[i][j]+dp[i-1][j-1];
                        int rd=matrix[i][j]+dp[i-1][j+1];
                        int d=matrix[i][j]+dp[i-1][j];
                        dp[i][j]=Math.min(d,Math.min(ld,rd));
                    }
                    else{
                       dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]); 
                    }
                }
                min=Math.min(min,dp[i][j]);
            }
        }
        return min;
    }
    int tabuWithSO(int[][] matrix,int n,int dp[]){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Integer.MAX_VALUE;
            int temp[]=new int[n];
            for(int j=0;j<n;j++){
                if(i==0){
                    temp[j]=matrix[0][j];
                }
                else{
                    if(j==0){
                        temp[j]=matrix[i][j]+Math.min(dp[j],dp[j+1]);
                    }
                    else if(n-1!=j){
                        int ld=matrix[i][j]+dp[j-1];
                        int rd=matrix[i][j]+dp[j+1];
                        int d=matrix[i][j]+dp[j];
                        temp[j]=Math.min(d,Math.min(ld,rd));
                    }
                    else{
                       temp[j]=matrix[i][j]+Math.min(dp[j],dp[j-1]); 
                    }
                }
                min=Math.min(min,temp[j]);
            }
            for(int j=0;j<n;j++){
                dp[j]=temp[j];
            }
        }
        return min;
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        /*
        //recursion
        int min=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            int cur=recur(matrix,0,j,n);
            min=Math.min(min,cur);
        }
        return min;
        */

        /*
        //memoisation
        int min=Integer.MAX_VALUE;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int j=0;j<n;j++){
            int cur=memoi(matrix,0,j,n,dp);
            min=Math.min(min,cur);
        }
        return min;
        */


        /*
        //tabu
        int min=Integer.MAX_VALUE;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return tabu(matrix,n,dp);
        */

        //tabu with space optimisation
        int dp[]=new int[n];
        return tabuWithSO(matrix,n,dp);
    }
}