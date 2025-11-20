class Solution {
    public boolean isPerfectSquare(int num) {
        int l=1,r=num;
        while(l<=r){
            long mid=(r+l)/2;
            long sq=mid*mid;
            if(sq==num){
                return true;
            }
            else if(sq>num){
                r=(int)(mid-1);
            }
            else{
                l=(int)(mid+1);
            }
        }
        return false;
    }
}