class Solution {
    int findMin(int start[],int startd[],int end[],int endd[]){
        int n1=start.length,n2=end.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n1;i++){
            int temp=start[i]+startd[i];
            for(int j=0;j<n2;j++){
                if(temp>=end[j]){
                    min=Math.min(min,temp+endd[j]);
                }
                else{
                    min=Math.min(min,endd[j]+end[j]);
                }
            }
        }
        
        return min;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

      return Math.min(findMin(landStartTime,landDuration,waterStartTime,waterDuration),findMin(waterStartTime,waterDuration,landStartTime,landDuration));

    }
}