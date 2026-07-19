class Solution {
    void recur(int n,List<String> ans,StringBuilder sb,int open,int close){
        if(open==n && close==n){
            ans.add(sb.toString());     
            return;      
        }

        StringBuilder temp=new StringBuilder(sb);
        if(open<n){ 
            temp=temp.append("(");
            recur(n,ans,temp,open+1,close);
        }
        if(close<n && open>close){ 
            temp=new StringBuilder(sb);
            temp=temp.append(")");
            recur(n,ans,temp,open,close+1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        recur(n,ans,sb,0,0);
        return ans;
    }
}