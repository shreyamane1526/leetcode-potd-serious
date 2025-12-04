class Solution {
    public int arraySign(int[] nums) {
        int ans=1;
        for(int x:nums){
            if(x==0){
                return 0;
            }
            else if(ans==-1 && x<0){
                ans=1;
            }
            else if(x<0){
                ans=-1;
            }
        }
        return ans;
    }
}