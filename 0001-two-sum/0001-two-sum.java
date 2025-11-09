class Solution {
    public int[] twoSum(int[] nums, int target) {
      Arrays.sort(nums);
      int ans[]=new int[2];
      int i=0,j=nums.length-1;
      while(i<j){
        if(nums[i]+nums[j]==target){
            ans[0]=i;
            ans[1]=j;
            return ans;
        }
        else if(nums[i]+nums[j]>target){
            j--;
        }
        else{
            i++;
        }
      }
     return ans;
    }
}