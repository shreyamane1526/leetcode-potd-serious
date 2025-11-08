class Solution {
    public static int fib_tab(int n,int dp[]){
        if(n<=2){
            return n;
        }
        dp[0]=0;dp[1]=1;dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static int fib_memotd(int n,int dp[]){
        if(n<=2){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=fib_memotd(n-1,dp)+fib_memotd(n-2,dp);
        return dp[n];
        //tc O(N)  sc=O(N)
    }
    public static int fib_rec(int n){
        if(n<=2){
            return n;
        }
        return fib_rec(n-1)+fib_rec(n-2);
        //tc= O(2^n)
        //sc=O(N)-recursion stack 
        //got tle 
    }
    public int climbStairs(int n) {
      // return fib_rec(n);
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        //return fib_memotd(n,dp);
        return fib_tab(n,dp);
    }
}