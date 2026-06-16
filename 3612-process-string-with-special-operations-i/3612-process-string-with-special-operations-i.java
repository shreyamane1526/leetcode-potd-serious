class Solution {
    public String processStr(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(Character.isLetter(s.charAt(i))){
                sb.append(Character.toString(s.charAt(i)));
            }
            else if(sb.length()>=1 && s.charAt(i)=='*'){
                sb.delete(sb.length()-1,sb.length());
            }
            else if(s.charAt(i)=='#'){
                sb.append(sb);
            }
            else if(s.charAt(i)=='%'){
                sb=sb.reverse();
            }
        }
        return sb.toString();
    }
}