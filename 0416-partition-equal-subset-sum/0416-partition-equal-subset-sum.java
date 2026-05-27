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
    public boolean canPartition(int[] nums) {
        int tot=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            tot+=nums[i]; 
        }
        if(tot%2!=0){
            return false;
        }
        //return targetSumRecur(nums,n-1,tot/2);
        int dp[][]=new int[n][(tot/2)+1];
        return targetSumMemoi(nums,n-1,tot/2,dp);
    }
}