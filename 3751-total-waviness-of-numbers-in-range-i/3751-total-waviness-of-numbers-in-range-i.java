class Solution {
    public int totalWaviness(int num1, int num2) {
        int wavy=0;
        for(int k=num1;k<=num2;k++){
            String temp=Integer.toString(k);
            int len=temp.length();
            if(len>=3){
                for(int i=1;i<len-1;i++){
                    if(temp.charAt(i)>temp.charAt(i-1) && temp.charAt(i)>temp.charAt(i+1)){
                        wavy++;
                    }
                    else if(temp.charAt(i)<temp.charAt(i-1) && temp.charAt(i)<temp.charAt(i
                    +1)){
                        wavy++;
                    }
                }
            }
        }
        return wavy;
    }
}