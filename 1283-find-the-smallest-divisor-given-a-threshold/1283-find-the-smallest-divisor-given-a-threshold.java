class Solution {
    public static int checksum(int nums[],int mid,int t){
        int c=0;
        for(int i=0;i<nums.length;i++){
            int k=nums[i]/mid;
            if(nums[i]%mid>0){k++;}
            c+=k;
        }
        if(c<=t){return 1;}
        return 0;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int min=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max){max=nums[i];}
            if(nums[i]<min){min=nums[i];}
        }
        int l=1,r=max;int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(checksum(nums,mid,threshold)==1){
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