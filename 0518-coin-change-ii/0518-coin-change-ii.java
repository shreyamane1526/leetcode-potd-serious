class Solution {
    int recur(int amount,int coins[],int n){
        if(n==-1){
            if(amount==0){
                return 1;
            }
            return 0;
        }
        int pick=0;
        if(amount-coins[n]>=0){
            pick=recur(amount-coins[n],coins,n);
        }
        int notPick=recur(amount,coins,n-1);
        return pick+notPick;
    }
    int memoise(int amount,int coins[],int n,int dp[][]){
        if(n==-1){
            if(amount==0){
                return 1;
            }
            return 0;
        }
        if(dp[n][amount]!=-1){
            return dp[n][amount];
        }
        int pick=0;
        if(amount-coins[n]>=0){
            pick=memoise(amount-coins[n],coins,n,dp);
        }
        int notPick=memoise(amount,coins,n-1,dp);
        return dp[n][amount]=pick+notPick;
    }
    int tabu(int amount,int coins[],int n){
        int dp[][]=new int[n][amount+1];
        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0){
                dp[0][j]=1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notPick=dp[i-1][j];
                int pick=0;
                if(coins[i]<=j){
                    pick=dp[i][j-coins[i]];
                }
                dp[i][j]=pick+notPick;
            }
        }
        return dp[n-1][amount];
    }

    public int change(int amount, int[] coins) {
        int n=coins.length;
        //return recur(amount,coins,n-1);
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        //return memoise(amount,coins,n-1,dp);
        return tabu(amount,coins,n);
    }
}