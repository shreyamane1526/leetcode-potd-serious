class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int pre[]=new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                pre[i]=nums[i];
            }
            else{ 
                pre[i]=nums[i]+pre[i-1];
            }
        }
        for(int i=0;i<n;i++){
            if(i==0){
                ans[i]=pre[n-1]-pre[0];
            }
            else if(i==n-1){
                ans[i]=pre[n-2];
            }
            else{ 
                ans[i]=Math.abs(pre[i-1]-(pre[n-1]-pre[i]));
            }
        }
        return ans;
    }
}