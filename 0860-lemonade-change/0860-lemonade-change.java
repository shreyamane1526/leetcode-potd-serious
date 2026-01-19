class Solution {
    public boolean lemonadeChange(int[] bills) {
        int x=0,y=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                x++;
            }
            else if(bills[i]==10){
                y++;
            }
            if(bills[i]==5){continue;}
            else if(bills[i]==10 && x>0){
                x--;
            }
            else if(bills[i]==20 && x>0 && y>0){
                x--;y--;
            }
            else if(bills[i]==20 && x>2){
                x-=3;
            }
            else{
                return false;
            }
        }
        return true;
    }
}