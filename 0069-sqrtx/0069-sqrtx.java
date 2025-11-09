class Solution {
    public int mySqrt(int x) {
        if(x<=1){return x;}
        int l=0,r=x/2;
        int ans=1;
        while(l<=r){
            long mid=l+(r-l)/2;
            long sq=mid*mid;
            if(sq==x){
                return (int)mid;
            }
            else if(sq<x){
                ans=(int)mid;
                l=(int)mid+1;
            }
            else{
                r=(int)mid-1;
            }
        }
        return ans;
    }
}