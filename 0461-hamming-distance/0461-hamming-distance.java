class Solution {
    public int hammingDistance(int x, int y) {
     int xor=x^y;
     int c=0;
     while(xor>0){
        if((1&xor)==1)c++;
        xor>>>=1;
     }  
     return c;
    }
}