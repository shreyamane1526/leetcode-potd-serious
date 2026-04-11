class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> li=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            li.add(new ArrayList<>());
            li.get(i).add(nums[i]);
            li.get(i).add(i);
        }
      Collections.sort(li,(a,b)->Integer.compare(a.get(0),b.get(0)));
      int ans[]=new int[2];
      int i=0,j=nums.length-1;
      while(i<j){
        if(li.get(i).get(0)+li.get(j).get(0)==target){
            ans[0]=li.get(i).get(1);
            ans[1]=li.get(j).get(1);
            return ans;
        }
        else if(li.get(i).get(0)+li.get(j).get(0)>target){
            j--;
        }
        else{
            i++;
        }
      }
     return ans;
    }
}