class Solution {
    public static double powm(double prod,double pow,long n){
        if(n<=0){return prod;} 
        if(n%2==1){       
        prod=prod*pow;
        }
        pow=pow*pow;
        n/=2;
        return powm(prod,pow,n);
    }
    public double myPow(double x, int n) {
        boolean flag=true;
        long p=n;
       if(n<0){
        flag=false;
        p=Math.abs((long)n);
       }
       double prod=1,pow=x;

       double ans=powm(prod,pow,p);
       if(!flag){return 1/ans;}
       return ans;
    }
}