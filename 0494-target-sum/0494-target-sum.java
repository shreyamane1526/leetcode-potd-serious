class Solution {
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
    
    int recurTrick(int nums[],int target,int n,int cur,int totSum){
        if(n==-1){
            if(2*cur-totSum==target){
                return 1;
            }
            else{
                return 0;
            }
        }
        int pick=0;
        if(2*(cur+nums[n])-totSum<=target){pick=recurTrick(nums,target,n-1,cur+nums[n],totSum);}
        int notPick=recurTrick(nums,target,n-1,cur,totSum);
        return pick+notPick;
    }
    int memoiseTrick(){
        return 0;
    }
    int tabu(){
        return 0;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        //return recur(nums,target,n-1,0);
        int totSum=0;
        for(int i=0;i<n;i++){
            //2s1-totSum=target
            //s1+s2=totSum
            totSum+=nums[i];
        }
        return recurTrick(nums,target,n-1,0,totSum);
    }
}