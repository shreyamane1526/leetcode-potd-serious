class Solution {
    double brute(int nums1[],int nums2[]){
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
    double partition(int nums1[],int nums2[]){
        int n=nums1.length;
        int m=nums2.length;
        if(n>m){
            return partition(nums2,nums1);
        }
        int l=0,r=n;
        while(l<=r){
            int mid=l+(r-l)/2;
            int part1=mid;
            int part2=(m+n+1)/2-part1;          
            int l1=(part1==0)?Integer.MIN_VALUE:nums1[part1-1];
            int l2=(part2==0)?Integer.MIN_VALUE:nums2[part2-1];
            int r1=(part1==n)?Integer.MAX_VALUE:nums1[part1];
            int r2=(part2==m)?Integer.MAX_VALUE:nums2[part2];
            if(l1<=r2 && l2<=r1){
                if((n+m)%2==0){
                    return (double)(Math.max(l2,l1)+Math.min(r2,r1))/2;
                }
                else{
                    return Math.max(l2,l1);
                }
            }
            else if(l1>r2){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return 0;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return partition(nums1,nums2);
    }
}