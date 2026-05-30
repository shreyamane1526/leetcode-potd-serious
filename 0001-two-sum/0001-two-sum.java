class Solution {
    public int[] hashing(int[] nums,int target){
        int ans[]=new int[2];
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(hm.containsKey(target-nums[i])){
                ans[0]=hm.get(target-nums[i]);
                ans[1]=i;
                return ans;
            }
            else{
                hm.put(nums[i],i);
            }
        }
        return ans;
    }
    public int[] sorting(int[] nums,int target){
        //int ans[]=new int[2];
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
            ans[0]=(int)li.get(i).get(1);
            ans[1]=(int)li.get(j).get(1);
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
    public int[] twoSum(int[] nums, int target) {
        return hashing(nums,target);
    }
}