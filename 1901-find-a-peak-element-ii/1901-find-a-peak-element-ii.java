class Solution {
    int findMax(int mat[][],int col,int r){
        int max=0;
        for(int i=0;i<r;i++){
            if(mat[i][col]>mat[max][col]){
                max=i;
            }
        }
        return max;
    }
    public int[] findPeakGrid(int[][] mat) {
        int r=mat.length;
        int c=mat[0].length;
        int l=0,h=c-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            int max=findMax(mat,mid,r);
            if(mid-1>0 && mat[max][mid-1]>mat[max][mid]){
                h=mid-1;
            }
            else if(mid+1<c && mat[max][mid+1]>mat[max][mid]){
                l=mid+1;
            }
            else{
                return new int[]{max,mid};
            }
        }
        return new int[]{-1,-1};
    }
}