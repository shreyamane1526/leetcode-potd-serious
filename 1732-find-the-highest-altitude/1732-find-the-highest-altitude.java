class Solution {
    public int largestAltitude(int[] gain) {
        int max=0;
        int prev=0,n=gain.length;
        for(int i=0;i<n;i++){
            int alt=gain[i]+prev;
            if(alt>max){
                max=alt;
            }
            prev=alt;
        }
        return max;
    }
}