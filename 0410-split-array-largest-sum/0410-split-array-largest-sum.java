class Solution {
    public int f(int nums[],int mid,int n){
        int possi=0;
        int cur=0;
        for(int i=0;i<n;i++){
            if(cur+nums[i]<=mid){
                cur+=nums[i];
            }
            else{
                possi++;
                cur=nums[i];
            }
        }
        if(cur>=0 && cur<=mid){
            possi++;
        }
        return possi;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        if(k>n){
            return 0;
        }
        int max=0,sum=0;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
            sum+=nums[i];
        }
        int l=max,r=sum;
        int ans=max;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(f(nums,mid,n)<=k){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
            
        }
        return ans;
    }
}