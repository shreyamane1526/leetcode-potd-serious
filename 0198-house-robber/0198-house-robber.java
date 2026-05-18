class Solution {
    public int recur(int nums[],int max,int cur,int idx,int n,int prev){
        if(idx==n){
            max=Math.max(max,cur);
            return max; 
        }
        int store=prev;
        if(idx-prev>1){ 
            cur+=nums[idx];
            prev=idx;
        }
        max=recur(nums,max,cur,idx+1,n,prev);
        cur-=nums[idx];
        prev=store;
        max=recur(nums,max,cur,idx+1,n,prev);
        return max;
    }
    public int tabu(int nums[],int dp[]){
        int n=nums.length;
        dp[0]=nums[0];
        if(n>1){
            dp[1]=Math.max(nums[0],nums[1]);
        }
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        //int maxMoney=0,idx=0,n=nums.length,cur=0, prev=-2;
        //return recur(nums,maxMoney,cur,idx,n,prev);
        int n=nums.length; 
        int dp[]=new int[n];
        return tabu(nums,dp);
    }
}
/*
idx=0
cur=1 
  idx+1=f(1) cur=
*/