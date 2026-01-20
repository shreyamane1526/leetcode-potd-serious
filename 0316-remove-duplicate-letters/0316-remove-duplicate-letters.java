class Solution {
    public String removeDuplicateLetters(String s) {
        int vis[]=new int[26];
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            freq[c-'a']--;
            if(vis[c-'a']==1){
                continue;
            }
            while(sb.length()>0){
                char l=sb.charAt(sb.length()-1);
                if(c<l && freq[l-'a']>0 && vis[c-'a']==0){
                    vis[l-'a']=0;
                    sb.deleteCharAt(sb.length()-1);
                }
                else{
                    break;
                }
            }
            sb.append(c);
            vis[c-'a']=1;
        }
        return sb.toString();
    }
}