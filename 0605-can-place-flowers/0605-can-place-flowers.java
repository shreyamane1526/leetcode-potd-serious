class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int c=0;
        if(flowerbed.length==0){
            if(n==0){return true;}
            return false;
        }
        else if(flowerbed.length==1){
            if((n<=1 && flowerbed[0]==0 )|| n==0){return true;}
            return false;
        }
        for(int i=0;i<flowerbed.length;i++){
            if(i==0 && flowerbed[i]==0 && flowerbed[i+1]!=1){
                c++;
                flowerbed[0]=1;
            }
            else if(i==flowerbed.length-1 && flowerbed[i]==0 && flowerbed[i-1]!=1){
                c++;flowerbed[i]=1;
            }
            else if(i>=0 && i<flowerbed.length-1 && flowerbed[i+1]!=1 && flowerbed[i]==0 && flowerbed[i-1]!=1){
                c++;flowerbed[i]=1;
            }
        }
        if(c>=n){return true;}
        return false;
    }
}