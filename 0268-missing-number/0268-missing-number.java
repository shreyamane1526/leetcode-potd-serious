class Solution {
    public int missingNumber(int[] nums) {
        //brute nlogn
        // Arrays.sort(nums);
        // int c=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==c){
        //         c++;
        //     }
        // }
        // return c;

        //optimal O(n)
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
        }
        for(int i=1;i<=nums.length;i++){
           xor^=i;
        }
        return xor;
    }
}