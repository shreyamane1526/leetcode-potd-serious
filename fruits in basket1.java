//fruits in basket 1 potd..6/8/2025
//approach 1 but giving wrong  gpt says correct lets see
class Solution {
    public int totalFruit(int[] fruits) {
        int b[]=new int[fruits.length];
        for(int i=0;i<fruits.length;i++){
            int c=0;
            if(fruits[i]==-1){continue;}
            for(int j=0;j<fruits.length;j++){
                
                if(fruits[i]==fruits[j]){
                    c++;
                    fruits[j]=-1;
                }
            }
            b[i]=c;
            }
            int max1=0,max2=0;
            for(int i=0;i<fruits.length;i++){
                if(b[i]>max1){
                    if(max1>max2){max2=max1;}
                    max1=b[i];
                }
                else if(b[i]>max2){
                     if(max2>max1){max1=max2;}
                    max2=b[i];
                }
               
               
            }
        return max1+max2;
    }
}
