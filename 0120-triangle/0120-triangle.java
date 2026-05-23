class Solution {
    int recur(List<List<Integer>> triangle,int i,int j,int n){
        if(i==n-1){
            return triangle.get(i).get(j);
        }
        int cur=triangle.get(i).get(j)+recur(triangle,i+1,j,n),     
        next=triangle.get(i).get(j)+recur(triangle,i+1,j+1,n);
        return Math.min(cur,next);
    }
    int memoi(List<List<Integer>> triangle,List<List<Integer>> dp,int i,int j,int n){
        if(i==n-1){
            return triangle.get(i).get(j);
        }
        if(dp.get(i).size()>j){
            return dp.get(i).get(j);
        }
        int cur=triangle.get(i).get(j)+memoi(triangle,dp,i+1,j,n),next=triangle.get(i).get(j)+memoi(triangle,dp,i+1,j+1,n);
       dp.get(i).add(Math.min(cur,next));
       return dp.get(i).get(j);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        //return recur(triangle,0,0,n);
        List<List<Integer>> dp=new ArrayList<>();
        for(int i=0;i<n;i++){
            dp.add(new ArrayList<>());
        }
        return memoi(triangle,dp,0,0,n);
    }
}