class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int c=0;
        long sum=0;
        int prev=0;
        int idx=0;
        for(int i=1;i<=target;i++){
            if(idx<coins.length && coins[idx]<=i){
                sum+=coins[idx++];
            }
            if(i>sum){
                c++;
                sum+=i;
            }
            
        }
        return c;
    }
}