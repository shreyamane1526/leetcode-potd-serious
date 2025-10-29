class Solution {
    
    public int smallestNumber(int n) {
       int ans=1,pow=2;;
       while(ans<n){
        ans+=pow;
        pow*=2;
       }  
       return ans; 
    }
}