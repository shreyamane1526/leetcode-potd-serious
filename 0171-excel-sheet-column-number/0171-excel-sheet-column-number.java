class Solution {
    public int titleToNumber(String s) {
        int i=s.length()-1;
        int sum=0;
        int mul=1;
        while(i>=0){
           sum+=mul*(s.charAt(i)-'A'+1);
           mul*=26;
           i--; 
        }
        return sum;
    }
}