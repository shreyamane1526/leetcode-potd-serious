class Solution {
    public int findMin(int[] arr) {
        int l=0,r=arr.length-1;
        int min=Integer.MAX_VALUE;
        while(l<=r){
            int mid=l+(r-l)/2;
           if(arr[mid]>=arr[l]){
                min=Math.min(min,arr[l]);
                l=mid+1;               
            }
            else{
                r=mid;
            }
        }
        return min;
    }
}