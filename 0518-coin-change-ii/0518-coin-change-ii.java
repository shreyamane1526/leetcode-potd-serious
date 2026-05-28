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
    public int change(int amount, int[] coins) {
        int n=coins.length;
        //return recur(amount,coins,n-1);
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return memoise(amount,coins,n-1,dp);
    }
}