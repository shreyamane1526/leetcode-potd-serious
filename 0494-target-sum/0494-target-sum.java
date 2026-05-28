class Solution {
    /*
    [1,1,1,1,1], target=3
    int idx=4,
    neg=
        -1,3
            -2,2
                -3,1
                    -4,0
                        -5,-1
                        -3,-1
                    -2,0
                        -3,-1
                        -1,-1
                -1,1
                    -2,0
                        -3,-1
                        -1,-1
                    0,0
                        -1,-1
                         1,-1
            0,2
                -1,1
                    -2,0
                        -3,-1
                        -1,-1
                    0,0
                        -1,-1
                         1,-1
                1,1
                    0,0
                        -1,-1
                        1,-1
                    2,0
                        -1,-1
                         3,-1

    pos=
    */
    int recur(int[] nums,int target,int n,int cur){
        if(n==-1){
            if(cur==target){ 
                return 1;
            }
            return 0;
        }
        int neg=+recur(nums,target,n-1,cur-nums[n]);
        int pos=recur(nums,target,n-1,cur+nums[n]);
        return neg+pos;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return recur(nums,target,n-1,0);
    }
}