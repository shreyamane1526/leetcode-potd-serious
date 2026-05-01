class Solution {
    public int maxArea(int[] height) {
        int area=0;
        int width=height.length-1;
        int i=0,j=width;
        while(i<j){
            int h=Math.min(height[i],height[j]);
            int a=h*width;
            if(a>area){
                area=a;
            }
            if(height[i]>=height[j]){
                j--;
            }
            else{
                i++;
            }
            width--;
        }
        return area;
    }
}