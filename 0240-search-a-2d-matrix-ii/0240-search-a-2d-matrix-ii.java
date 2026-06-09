class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length;
        int c=matrix[0].length;
        int cur=matrix[0][c-1];
        int curR=0,curC=c-1;
        while(curR<r && curC>=0){
            cur=matrix[curR][curC];
            if(cur==target){
                return true;
            }
            else if(cur>target){
                curC--;
            }
            else{
                curR++;
            }
        }
        return false;
    }
}