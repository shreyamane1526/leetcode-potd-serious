class Solution {
    public int maximumCount(int[] arr) {
        int l=0,r=arr.length-1;
        int neg=-1,pos=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=0){
                r=mid-1;
            }
            else{
                neg=mid;
                l=mid+1;
            }
        }
        l=0;r=arr.length-1;
         while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]<=0){
                l=mid+1;
            }
            else{
                pos=mid;
                r=mid-1;
            }
        }
        if(neg==-1 && pos==-1){
            return 0;
        }
        if(neg==-1){
            return arr.length-pos;
        }
        if(pos==-1){return neg+1;}
        return Math.max(neg+1,arr.length-pos);
    }
}