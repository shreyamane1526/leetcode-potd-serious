class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int arr[]=new int[2];int m=0;
        for(int i=0;i<nums.length;i++){
            nums[i]++;
        }
       for(int i=0;i<nums.length;i++){
          int index=Math.abs(nums[i])-1;
          if(nums[index]<0){
            arr[m++]=Math.abs(nums[i])-1;
          }
          else{
            nums[index]=-nums[index];
          }
          if(m==2){break;}
       } 
       return arr;
    }
}