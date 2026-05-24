class Solution {
    public int longestPalindrome(String s) {
        int ch[]=new int[256];
        Arrays.fill(ch,0);
        int n=s.length();
        for(int i=0;i<n;i++){
            ch[s.charAt(i)]++;
        }
        boolean flag=false;
        int c=0;
        for(int i=0;i<256;i++){
           if(ch[i]%2==0){
            c+=ch[i];
           }
           else{
            flag=true;
            c+=ch[i]-1;
           }
        }
        if(flag){ 
            c+=1;
        }
        return c;
    }
}