class Solution {
    int digitSum(int nums[]){
        int n=nums.length,min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){ 
                int a=nums[i];
                int r=0;
                while(a!=0){
                    r+=a%10;
                    a/=10;
                }
                nums[i]=r;
                if(r<min){
                    min=r;
                }
        }
        return min;
    }
    public int minElement(int[] nums) {
        return digitSum(nums);
    }
}