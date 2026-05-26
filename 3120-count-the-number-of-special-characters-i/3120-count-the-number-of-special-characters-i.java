class Solution {
    public int numberOfSpecialChars(String s) {
        String temp=s.toLowerCase();
        int ch[]=new int[26];
        int n=s.length();
        int c=0;
        for(int i=0;i<n;i++){
            int pos=temp.charAt(i)-'a';
            if(temp.charAt(i)==s.charAt(i) && ch[pos]!=2){
                if(ch[pos]==-1){
                    ch[pos]=2;
                    c++;
                }
                else{ 
                    ch[pos]=1;
                }
            }
            else if(temp.charAt(i)!=s.charAt(i) && ch[pos]!=2){
                if(ch[pos]==1){
                    ch[pos]=2;
                    c++;
                }
                else{ 
                    ch[pos]=-1;
                }
            }
        }
        return c;
    }
}