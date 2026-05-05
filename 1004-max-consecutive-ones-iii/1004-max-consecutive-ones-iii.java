class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int n=nums.length;
        int altered=0;
        int max=0;
        int cur=0;
        for(int r=0;r<n;r++){
            if(nums[r]==1){
                cur++;
            }
            else if(k!=0){
                if(altered<k){
                    altered++;
                    cur++;
                }
                else{
                    max=Math.max(cur,max);
                    while(nums[left]==1){
                        left++;
                        cur--;
                    }
                    if(left<r && nums[left]==0){ 
                        left++;
                        altered--;
                        cur--;
                    }   
                    altered++;
                    cur++;             
                }
            }
            else{
                max=Math.max(cur,max);
                cur=0;
            }
        }
        max=Math.max(cur,max);
        return max;
    }
}