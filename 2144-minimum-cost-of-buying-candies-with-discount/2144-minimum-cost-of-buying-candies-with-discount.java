class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n=cost.length;
        int j=0;
        int ans=0;
        if(n%3==2){
            ans+=cost[0]+cost[1];
        }
        if(n%3==1){
            ans+=cost[0];
        }
        if(n>=3){ 
        for(int i=n-1;i>=2;i-=3){
           ans+=cost[i]+cost[i-1];
        }
        }
        return ans;
    }
}