class Solution {
    public String largestOddNumber(String num) {
        for(int i=num.length()-1;i>=0;i--){
            if(Integer.parseInt(Character.toString(num.charAt(i)))%2!=0){
                System.out.print(num.charAt(i)-'0');
                return num.substring(0,i+1);
                
            }
        }
        return "";
    }
}