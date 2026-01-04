class Solution {
    public int addDigits(int num) {
        
        while(num>=10){
            int a=num;
            int x=0;
            while(a>0){
                int r=a%10;
                x+=r;
                a/=10;
            }
            num=x;
        }
        return num;
    }
}