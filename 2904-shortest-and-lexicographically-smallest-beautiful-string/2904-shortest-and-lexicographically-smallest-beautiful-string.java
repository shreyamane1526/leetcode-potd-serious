class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String prev="";
        int c=0;
        int first=-1;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                if(first==-1){
                    first=i;
                }
                c++;
            }
            if(k==1 && c==1){
                return "1";
            }
            if(c==k){
                String cur=s.substring(first,i+1);
                if(prev.equals("")){
                    prev=cur;
                }
                else if(prev.length()>cur.length()){
                    prev=cur;
                }
                else if(prev.length()==cur.length() &&prev.compareTo(cur)>=0){
                    prev=cur;
                }
                first++;
                while(first<n && s.charAt(first)!='1'){
                    first++;
                }
                c--;
            }
        }
        return prev;
    }
}