class Solution {
    boolean isPalindrome(StringBuilder sb){
        int n=sb.length();
        int i=0,j=n-1;
        while(i<j){
            if(sb.charAt(i)!=sb.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n=s.length(),max=0;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<n;j++){
                sb.append(Character.toString(s.charAt(j)));               
                if(max<j-i+1){ 
                    if(isPalindrome(sb)){
                        max=Math.max(max,j-i+1);
                        ans=new StringBuilder(sb);
                    }
                }
                
            }
        }
        return ans.toString();
    }
}