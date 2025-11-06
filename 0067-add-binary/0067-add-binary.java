class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        int c=0;
        while(i>=0 || j>=0 || c==1){
            int ans=c;
            if(i>=0){ans+=a.charAt(i)-'0';}
            if(j>=0){ans+=b.charAt(j)-'0';}
            if(ans==0){
                c=0;
                sb.insert(0,"0");
            }
            else if(ans==1){
                c=0;
                sb.insert(0,"1");
            }
            else if(ans==2){
                c=1;
                sb.insert(0,"0");
            }
            else{
                c=1;
                sb.insert(0,"1");
            }
            i--;j--;
        }
        
      
        return sb.toString();
    }
}