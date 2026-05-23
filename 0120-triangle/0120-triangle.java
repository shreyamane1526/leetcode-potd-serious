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
    int tabu(List<List<Integer>> triangle,List<List<Integer>> dp){
        int n=triangle.size();
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                if(i==n-1){
                    dp.get(i).add(triangle.get(i).get(j));
                }
                else{
                    dp.get(i).add(triangle.get(i).get(j)+Math.min(dp.get(i+1).get(j),dp.get(i+1).get(j+1)));
                }
            }
        }
        return dp.get(0).get(0);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        //return recur(triangle,0,0,n);
        List<List<Integer>> dp=new ArrayList<>();
        for(int i=0;i<n;i++){
            dp.add(new ArrayList<>());
        }
        //return memoi(triangle,dp,0,0,n);
        return tabu(triangle,dp);
    }
}