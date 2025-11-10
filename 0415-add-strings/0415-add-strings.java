class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder();
        int i=num1.length()-1,j=num2.length()-1;
        int c=0;
        while(i>=0 && j>=0){
            sb.append((num1.charAt(i)-'0'+num2.charAt(j)-'0'+c)%10);
            c=((num1.charAt(i--)-'0'+num2.charAt(j--)-'0'+c)/10);
        }
        while(i>=0){
            sb.append((num1.charAt(i)-'0'+c)%10);
            c=((num1.charAt(i--)-'0'+c)/10);
        }
        while(j>=0){
            sb.append((num2.charAt(j)-'0'+c)%10);
            c=((num2.charAt(j--)-'0'+c)/10);
        }
        if(c!=0){
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}