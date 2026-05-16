class Solution {
    public int findMin(int[] nums) {
        //bs
        //2 2 0 2 2 2 if this then prune l ,r --- ya case madhe worst case tc O(n) ch yeil
        //0 1 2 3 4 5 mid 
        int n=nums.length;
        int l=0,r=n-1;
        int min=nums[0];
        while(l<=r){
            int mid=l+(r-l)/2;
            if(l!=mid && mid!=r && nums[l]==nums[mid] && nums[mid]==nums[r]){
                l++;r--;
                continue;
            }
            else if(nums[l]<=nums[mid]){
                if(min>nums[l]){
                    min=nums[l];
                }
              l=mid+1;
            }
            else{
                //6 7 1 2 3 4 5 6 
                if(min>nums[mid]){
                    min=nums[mid];
                }
                r=mid-1;
            }
        }
        return min;
    }
}
/*brute
        int min=nums[0],n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<min){
                min=nums[i];
            }
        }
        return min;
        */