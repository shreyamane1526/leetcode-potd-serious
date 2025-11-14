class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0,r=nums.length-1;
        if(r==0){
            return nums[0];
        }
        if(nums[0]==nums[1]){
            l++;
        }
        else{
            return nums[0];
        }
        if(nums[r]==nums[r-1]){
            r--;
        }
        else{
            return nums[r];
        }
        while(l<=r){
            int mid=l+(r-l)/2;
            if(mid%2==0){
                if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1] ){ return nums[mid]; } 
                else{
                    if(nums[mid]==nums[mid+1]){
                        l=mid+1;
                    }
                    else{
                        r=mid-1;
                    }
                }
            }
            else{
               if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1] ){ return nums[mid]; } 
                else{
                    if(nums[mid]==nums[mid-1]){
                        l=mid+1;
                    }
                    else{
                        r=mid-1;
                    }
                } 
            }
        }
        return 0;
    }
}