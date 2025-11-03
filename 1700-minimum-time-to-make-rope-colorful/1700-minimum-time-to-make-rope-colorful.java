class Solution {
    public int minCost(String colors, int[] neededTime) {
        int time=0;
        for(int i=0;i<colors.length()-1;i++){
            if(colors.charAt(i)==colors.charAt(i+1)){
                char c=colors.charAt(i);
                int j=i+1;
                int max=neededTime[i];
                time+=max;
                while(  j<colors.length() && c==colors.charAt(j)){
                    time+=neededTime[j];
                    if(max<neededTime[j]){
                        max=neededTime[j];
                    }j++;
                }
                time-=max;
                i=j-1;
            }
        }
        return time;
    }
}