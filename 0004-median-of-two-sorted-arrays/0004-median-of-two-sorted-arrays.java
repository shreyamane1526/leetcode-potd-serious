class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int temp[]=new int[n+m];
        int idx=0;
        for(int i=0;i<n;i++){
            temp[idx++]=(nums1[i]);
        }
        for(int i=0;i<m;i++){
            temp[idx++]=(nums2[i]);
        }
        Arrays.sort(temp);
        if((n+m)%2==0){ //0 1 2  
            return (double)(temp[(n+m)/2]+temp[(n+m)/2-1])/2;
        }
        else{
            return temp[(m+n)/2];
        }
    }
}