class Solution {
    public int[] sortedSquares(int[] nums) {
        int ans[]=new int[nums.length];
        int i=0,j=nums.length-1;
        int idx=nums.length-1;
        while(i<=j){
            if(nums[i]*nums[i]>=nums[j]*nums[j]){
                ans[idx--]=nums[i]*nums[i];
                i++;
            }
            else{
                ans[idx--]=nums[j]*nums[j];
                j--;
            }
        }
        return ans;
    }
}