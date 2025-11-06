class Solution {
    public boolean isAnagram(String s, String t) {
        int ch[]=new int[26];
        int ch2[]=new int[26];
        s=s.toLowerCase();
        t=t.toLowerCase();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            ch[s.charAt(i)-'a']++;
            ch2[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(ch[i]!=ch2[i]){
                return false;
            }
        }
        return true;
    }
}