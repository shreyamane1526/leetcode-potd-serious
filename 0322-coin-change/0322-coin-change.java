class Solution {
    int recur(int coins[],int amount,int n){
        if(n==-1){
            if(amount==0){
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        int notTake=recur(coins,amount,n-1);
        int take=Integer.MAX_VALUE;
        if(coins[n]<=amount){
            take=recur(coins,amount-coins[n],n);
            if(take!=Integer.MAX_VALUE){
                take+=1;
            }
        }
        return Math.min(take,notTake);
    }
    int memoise(int coins[],int amount,int n,int dp[][]){
        if(n==-1){
            if(amount==0){
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(dp[n][amount]!=-1){
            return dp[n][amount];
        }
        int notTake=memoise(coins,amount,n-1,dp);
        int take=Integer.MAX_VALUE;
        if(coins[n]<=amount){
            take=memoise(coins,amount-coins[n],n,dp);
            if(take!=Integer.MAX_VALUE){
                take+=1;
            }
        }
        return dp[n][amount]=Math.min(take,notTake);
    }
    int tabu(int coins[],int amount,int n){
        int dp[][]=new int[n][amount+1];
        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0){ 
                dp[0][j]=j/coins[0];
            }
            else{
                dp[0][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notPick=dp[i-1][j];
                int pick=Integer.MAX_VALUE;
                if(coins[i]<=j){
                    if(dp[i][j-coins[i]]!=Integer.MAX_VALUE){
                        pick=1+dp[i][j-coins[i]];
                        
                    }
                }
                dp[i][j]=Math.min(pick,notPick);
            }
        }
        if(dp[n-1][amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[n-1][amount];
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        /*   rceur
        int ans=recur(coins,amount,n-1);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;     
        */  

        /*
        //memoise
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=memoise(coins,amount,n-1,dp);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans; 
        */

        return tabu(coins,amount,n);
    }
}