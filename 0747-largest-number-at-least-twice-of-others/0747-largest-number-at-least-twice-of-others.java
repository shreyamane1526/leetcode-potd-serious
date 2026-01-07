class Solution {
    public int dominantIndex(int[] nums) {
        int min=nums[1],max=nums[0];int idx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                min=max;
                max=nums[i];idx=i;
            }
            else if(i!=idx && min<nums[i]){
                min=nums[i];
            }
        }
        if(min*2<=max){
            return idx;
        }
        return -1;
    }
}