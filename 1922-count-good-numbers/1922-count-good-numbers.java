class Solution {
    long mod=1000000007;
    long pow(long base,long exp,long ans){ 
        if(exp==0){
            return ans;
        }
        if(exp%2!=0){
            ans=(ans*base)%mod;
        }
        return pow((base*base)%mod,exp/2,ans);
    }
    public int countGoodNumbers(long n) {
            long odd=((n+1)/2);
            long oddPow=pow(5,odd,1);
            long even=n/2;
            long evenPow=pow(4,even,1);
            int ans=(int)((evenPow*oddPow)%mod);
            return (int)ans;       
    }
}