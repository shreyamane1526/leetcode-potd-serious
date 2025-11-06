class Solution {
    public int[] plusOne(int[] digits) {
        int ans[]=new int[digits.length+1];
        int c=1;
        for(int i=digits.length-1;i>=0;i--){
            int cp=digits[i];
            ans[i+1]=(cp+c)%10;
            digits[i]=(cp+c)%10;
            c=(cp+c)/10;
        }
        ans[0]=c;
        if(ans[0]==0){
            return digits;
        }
        return ans;
    }
}