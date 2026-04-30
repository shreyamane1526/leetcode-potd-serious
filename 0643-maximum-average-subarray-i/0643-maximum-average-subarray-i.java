class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int kth=0,maxKthSum=0;
        for(int i=0;i<k;i++){
            maxKthSum+=nums[i];
        }
        int start=0;
        int n=nums.length;
        int max=maxKthSum;
        float avg=max;
        for(int i=k;i<n;i++){
            int temp=maxKthSum-nums[start]+nums[i];
            if(temp>max){
                max=temp;
            }
            
            maxKthSum+=nums[i]-nums[start];start++;
            
        }
        return (double)max/k;
    }
}