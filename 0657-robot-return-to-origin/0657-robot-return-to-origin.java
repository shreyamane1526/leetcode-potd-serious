class Solution {
    public boolean judgeCircle(String moves) {
        int x=0,y=0;
        for(int i=0;i<moves.length();i++){
            char c=moves.charAt(i);
            if( c=='R'){
                x+=2;
            }
            if(c=='L'){
                x-=2;
            }
            if(c=='U'){
                y+=2;
            }
            if(c=='D'){
                y-=2;
            }
        }
        if(x==0 && y==0){
            return true;
        }
        return false;
    }
}