class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int ans[]=new int[nums.length];
        int i=0,j=nums.length-1;
        for(int k=0;k<nums.length;k++){
            if(nums[k]%2==0){
                ans[i++]=nums[k];
            }
            else{
                ans[j--]=nums[k];
            }
        }
        return ans;
    }
}