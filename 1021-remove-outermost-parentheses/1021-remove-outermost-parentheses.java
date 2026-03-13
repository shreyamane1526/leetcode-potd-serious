class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans=new StringBuilder(s);
        int c=0;
        int first=-1;
        ArrayList<Integer> li=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(first==-1 && s.charAt(i)=='('){
                first=i;
            }
            if(s.charAt(i)=='('){
                c++;
            }
            else if(s.charAt(i)==')'){
                c--;
            }
            if(c==0){
                li.add(first);
                li.add(i);
                first=-1;
            }
        }
        for(int i=li.size()-1;i>=0;i--){
            ans.delete(li.get(i),li.get(i)+1);
        }      
        return ans.toString();
    }
}