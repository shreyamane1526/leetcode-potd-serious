class Solution {
    public int heightChecker(int[] heights) {
        int dup[]=new int[heights.length];int i=0;
        for(int c:heights){
            dup[i++]=c;
        }
        int ct=0;
        Arrays.sort(dup);i=0;
        for(i=0;i<heights.length;i++){
            if(dup[i]!=heights[i]){
                ct++;
            }
        }
        return ct;
    }
}