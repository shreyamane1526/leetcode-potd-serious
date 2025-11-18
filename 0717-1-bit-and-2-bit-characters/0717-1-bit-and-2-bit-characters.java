class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i=0;
        for( i=0;i<bits.length-1;i++){
            if(i==bits.length-1){return true;}
            if(bits[i]==0){
                continue;
            }
            else if((bits[i]==1 && bits[i+1]==0)|| (bits[i]==1 && bits[i+1]==1)){
                i++;
            }
        }
        if(i==bits.length){return false;}
        return true;
    }
}