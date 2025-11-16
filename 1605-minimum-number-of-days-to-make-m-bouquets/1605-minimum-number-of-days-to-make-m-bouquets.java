class Solution {
    public static int func(int arr[],int d,int m,int k){
        int c=0,ans=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=d){
                c++;
            }
            else{
                ans+=c/k;
                c=0;
            }
        }
        ans+=c/k;
        if(ans>=m){
            return 1;
        }
        else return 0;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<m*k){return -1;}
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            if(min>bloomDay[i]){min=bloomDay[i];}
            if(max<bloomDay[i]){max=bloomDay[i];}
        }
        int l=min,r=max;int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(func(bloomDay,mid,m,k)==1){
                ans=mid;
                r=mid-1;
            }
            else{l=mid+1;}
        }
        return ans;
    }
}