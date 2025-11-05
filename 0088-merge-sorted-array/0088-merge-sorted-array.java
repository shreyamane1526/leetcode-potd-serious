class Solution {
     public static void ans(int a1[],int a2[],int m,int n){
        int i=n;int j=0,idx=0;
        while(idx<m+n){
            if(i<m+n && j<n){ 
            if(a1[i]<a2[j]){
                a1[idx++]=a1[i++];
            }
            else{
                a1[idx++]=a2[j++];
            }
            }
            else{
                if(i==a1.length){
                    a1[idx++]=a2[j++];
                }
                else{
                    a1[idx++]=a1[i++];
                }
            }
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx=m-1;
        for(int i=n+m-1;i>=n;i--){
            nums1[i]=nums1[idx--];
        }
        ans(nums1,nums2,m,n);
    }
}