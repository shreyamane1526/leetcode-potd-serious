class Solution {
    public boolean isPositive(String s,int i){
        if(s.charAt(i)=='-'){
            return false;
        }
        else if(s.charAt(i)=='+'){
            return true;
        }
        return true;
    }
    public int myAtoi(String s) {
        if(s.length()==0){
            return 0;
        }
        int i=0;int j=s.length();
        while(i<j && s.charAt(i)==' '){
            i++;
        }
        if(i>=j){
            return 0;
        }
        boolean positive=isPositive(s,i);
        if(i<j && (s.charAt(i)=='-' ||s.charAt(i)=='+')){i++;}
        while(i<j && s.charAt(i)=='0'){
            i++;
        }
        
        long x=0;
        while(i<j && (Character.isDigit(s.charAt(i)))){
            x=x*10+(s.charAt(i)-'0');i++;
            if(!positive && (-x)<=Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            else if(positive && (x)>=Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        
        if(!positive){
            
            return -((int)x);
        }
        
        return (int)x;
        
    }
}