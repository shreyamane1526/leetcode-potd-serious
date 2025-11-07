class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
        int c='A';
        int i=0;
        while(n!=0){
           int r=n%26;
           if(r!=0){sb.append(Character.toString((char)(c-1+r)));
            n=n-r;}
           else{
            sb.append(Character.toString((char)(c+25)));
            n=n-25;
           }
           
            n/=26;
        }
        return sb.reverse().toString();
    }
}
//1*char + 26* char+ 26^2*char +.....
//take mod by 26 rem will be 1st char then update n as n-char repeat?
// 