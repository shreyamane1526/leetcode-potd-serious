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
    int tabuWithSO(List<List<Integer>> Triangle,int n){
        List<Integer> dp=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){;
            min=Integer.MAX_VALUE;
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<Triangle.get(i).size();j++){
                if(i==0){
                    temp.add(Triangle.get(i).get(j));
                }
                else{
                    if(j==0){
                        temp.add(j,dp.get(j)+Triangle.get(i).get(j));
                    }
                    else if(j!=i){
                        temp.add(j,Triangle.get(i).get(j)+Math.min(dp.get(j),dp.get(j-1)));
                    }
                    else{
                        temp.add(Triangle.get(i).get(j)+dp.get(j-1));
                    }
                }
                if(min>temp.get(j)){
                    min=temp.get(j);
                }
            }
            for(int j=0;j<dp.size();j++){
                dp.set(j,temp.get(j));
            }
            dp.add(temp.get(dp.size()));
        }
        return min;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        //return recur(triangle,0,0,n);
        List<List<Integer>> dp=new ArrayList<>();
        for(int i=0;i<n;i++){
            dp.add(new ArrayList<>());
        }
        //return memoi(triangle,dp,0,0,n);
        //return tabu(triangle,dp);
        return tabuWithSO(triangle,n);
    }
}