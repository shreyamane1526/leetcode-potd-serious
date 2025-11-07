class Solution {
    public int mySqrt(int x) {
        if(x<2){return x;}
        int ans=0,l=0,r=x/2;
        while(l<=r){
          long mid=l+(r-l)/2;
            long sq=mid*mid;
            if(x== sq){
                return (int)mid;
            }
            else if(x< sq){
                r=(int)mid-1;
            }
            else{
                ans=(int)mid;
                l=(int)mid+1;
            }
        }
        return ans;
    }
}