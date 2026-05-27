class Solution {
    boolean targetSumRecur(int nums[],int n,int tar){
        if(tar==0){
            return true;
        }
        if(n==0){
            return nums[n]==tar?true:false;
        }
        if(tar-nums[n]>=0 && targetSumRecur(nums,n-1,tar-nums[n])){
            return true;
        }
        if(targetSumRecur(nums,n-1,tar)){
            return true;
        }
        return false;
    }
    //1 2 5,,,,,,2,,,,,4,,,,,,,dp
    //1,,4
      //0,2
        
      //0,4
    boolean targetSumMemoi(int nums[],int n,int tar,int dp[][]){
        if(tar==0){
            return true;
        }
        if(n==0){
            return nums[n]==tar?true:false;
        }
        if(dp[n][tar]==-1){
            return false;
        }
        if(tar-nums[n]>=0 && targetSumMemoi(nums,n-1,tar-nums[n],dp)){
            return true;
        }
        if(targetSumMemoi(nums,n-1,tar,dp)){
            return true;
        }
        dp[n][tar]=-1;
        return false;
    }
    boolean tabu(int nums[],int n,int tar,boolean dp[][]){
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(nums[0]<=tar){
            dp[0][nums[0]]=true;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=tar;j++){
                boolean notTake=dp[i-1][j];
                boolean take=false;
                if(nums[i]<=j){
                    take=dp[i-1][j-nums[i]];
                }
                dp[i][j]=notTake || take;
            }
        }
        return dp[n-1][tar];
    }
    boolean tabuWithSO(int nums[],int n,int tar){
        boolean dp[]=new boolean[tar+1];
        dp[0]=true;
        if(nums[0]<=tar){ 
            dp[nums[0]]=true; 
        }      
        for(int i=1;i<n;i++){
            boolean temp[]=new boolean[tar+1];
            temp[0]=true;
            for(int j=1;j<=tar;j++){
                boolean notTake=dp[j];
                boolean take=false;
                if(nums[i]<=j){
                    take=dp[j-nums[i]];
                }
                temp[j]=take || notTake;
            }
            for(int j=0;j<=tar;j++){
                dp[j]=temp[j];
            }
        }
        return dp[tar];
    }
    public boolean canPartition(int[] nums) {
        int tot=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            tot+=nums[i]; 
        }
        if(tot%2!=0 || (n==1)){
            return false;
        }
        //return targetSumRecur(nums,n-1,tot/2);
        //int dp[][]=new int[n][(tot/2)+1];
        //return targetSumMemoi(nums,n-1,tot/2,dp);
        boolean dp[][]=new boolean[n][(tot/2)+1];
        //return tabu(nums,n-1,tot/2,dp);
        return tabuWithSO(nums,n-1,tot/2);
    }
}