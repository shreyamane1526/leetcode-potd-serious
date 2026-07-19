class Solution {
    void recur(int n,List<String> ans,StringBuilder sb,int oc[]){
        if(n==0){
            if(oc[0]==0){ 
                ans.add(sb.toString());  
            }    
            return;      
        }
        if(oc[0]<0){
            return;
        }
        //open 
        StringBuilder temp=new StringBuilder(sb);
        temp=temp.append("(");
        oc[0]++;
        recur(n-1,ans,temp,oc);
        oc[0]--;
        //close
        temp=new StringBuilder(sb);
        temp=temp.append(")");
        oc[0]--;
        recur(n-1,ans,temp,oc);
        oc[0]++;
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        int oc[]=new int[1];
        oc[0]=0;
        recur(2*n,ans,sb,oc);
        return ans;
    }
}