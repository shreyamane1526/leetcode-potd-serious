class Solution {
    HashMap<Integer,String> dict=new HashMap<>(){{put(2,"abc");put(3,"def");put(4,"ghi");put(5,"jkl");put(6,"mno");put(7,"pqrs");put(8,"tuv");put(9,"wxyz");}};  

    void recur(List<String> li,String digits,int n,StringBuilder sb,int idx){
        if(idx==n){
            li.add(new String(sb.toString()));
            return;
        }
            int ch=digits.charAt(idx)-'0';
            String temp=dict.get(ch);
            int len=temp.length();
            for(int j=0;j<len;j++){
                sb.append(temp.charAt(j));
                recur(li,digits,n,sb,idx+1);
                sb.delete(sb.length()-1,sb.length());
            }
        
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        recur(ans,digits,digits.length(),sb,0);
        return ans;
    }
}