class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length,s=n/2;
        int c=0;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                c++;
                if(c>=s){
                    return nums[i];
                }
            }
            else{
                c=0;
            }
        }
        return nums[0];
    }
}