class Solution {
    void merge(int nums[],int low,int mid,int high){
        ArrayList<Integer> temp=new ArrayList<>();
        int i=low,j=mid+1;
        while(i<=mid && j<=high){
            if(nums[i]<=nums[j]){
                temp.add(nums[i++]);
            }
            else{
                temp.add(nums[j++]);
            }
        }
        while(i<=mid){
            temp.add(nums[i++]);
        }
        while(j<=high){
            temp.add(nums[j++]);
        }
        int idx=0;
        for(int k=low;k<=high;k++){
            nums[k]=temp.get(idx++);
        }
    }
    int countRev(int nums[],int low,int mid,int high){
        int i=low,j=mid+1;
        int ct=0;
        for(int l=low;l<=mid;l++){
            while(j<=high && (long)nums[l]>(long)nums[j]*2){
                j++;
            }
            ct+=j-(mid+1);
        }
        return ct;
    }
    int mergeSort(int nums[],int low,int high){
        int count=0;
        if(low<high){
            int mid=low+(high-low)/2;
            count+=mergeSort(nums,low,mid);
            count+=mergeSort(nums,mid+1,high);
            count+=countRev(nums,low,mid,high);
            merge(nums,low,mid,high);
        }
        return count;
    }
    public int reversePairs(int[] nums) {
        int n=nums.length;
        return mergeSort(nums,0,n-1);
    }
}