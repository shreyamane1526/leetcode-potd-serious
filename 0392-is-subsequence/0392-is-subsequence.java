class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()){
            return false;
        }
        int idx=0;
        for(int i=0;i<t.length();i++){
            if(idx==s.length()){
                return true;
            }
            if(t.charAt(i)==s.charAt(idx)){
                idx++;
            }
        }
        if(idx==s.length()){
            return true;
        }
        return false;
    }
}