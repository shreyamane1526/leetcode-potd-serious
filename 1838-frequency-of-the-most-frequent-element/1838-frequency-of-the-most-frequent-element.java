class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        long sum=0;int l=0,max=0;
        for(int i=0;i<n;i++){
            sum+=(long)nums[i];
            while((long)nums[i]*(i-l+1)-sum>k){ 
                sum-=(long)nums[l];
                l++;
            }
            max=Math.max(max,i-l+1);
        }
        return max;
    }
}