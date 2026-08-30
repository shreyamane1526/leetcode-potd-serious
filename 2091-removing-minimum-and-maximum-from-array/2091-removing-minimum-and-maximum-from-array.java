class Solution {
    public int minimumDeletions(int[] arr) {
        int min=arr[0],max=arr[0];
        int minIdx=0,maxIdx=0;
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
                maxIdx=i;
            }
            if(arr[i]<min){ 
                min=arr[i];
                minIdx=i;
            }
        }
        int l=Math.min(minIdx,maxIdx);
        int r=Math.max(minIdx,maxIdx);
        return Math.min(Math.min(r+1,n-l),l+1+n-r);
    }
}