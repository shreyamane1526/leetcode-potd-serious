class Solution {
    public int pivotIndex(int[] nums) {
        int pre[]=new int[nums.length];
        int n=nums.length;
        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        int l=0,r=0;
        for(int i=0;i<n;i++){
            if(i==0){
                if(pre[n-1]-pre[0]==0){return 0;}
            }
            else{
                l=pre[i-1];
                r=pre[n-1]-pre[i];
                if(l==r){
                    return i;
                }
            }
        }
        return -1;
    }
}