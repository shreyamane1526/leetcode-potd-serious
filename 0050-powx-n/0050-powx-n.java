class Solution {
    public static double pow(double x,int n,double pow,double prod){
        if(n==0){return prod;}
        if(n%2==1){
            prod=prod*pow;
        }
        pow*=pow;
        n/=2;
        return pow(x,n,pow,prod);
    }
    public double myPow(double x, int n) {
        if(x!=1&& x!=-1 && n==Integer.MIN_VALUE){return 0;}
        if((x==1 || x==-1 )&&  n==Integer.MIN_VALUE){return 1;}

        double prod=1;
        boolean flag=false;
        if(n<0){flag=true;}
        double pow=x;
        if(flag){
            return 1/pow(x,-n,pow,prod);
        }
        return pow(x,n,pow,prod);
    }
}