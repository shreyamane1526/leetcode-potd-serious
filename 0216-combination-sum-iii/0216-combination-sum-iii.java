class Solution {
    void recur(int n,int k,List<Integer> li,List<List<Integer>> ans,int start){
        if(n==0){
            if(li.size()==k){ 
                ans.add(new ArrayList<>(li));
            }
            return;
        }
        for(int j=start;j<=9;j++){
            if(li.size()<k && n>=j){
                li.add(j);
                recur(n-j,k,li,ans,j+1);
                li.remove(li.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        recur(n,k,li,ans,1);
        return ans;
    }
}