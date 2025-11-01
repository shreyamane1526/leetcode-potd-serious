class Solution {
    public static void powset(int[] nums, int target,List<List<Integer>> l2,List<Integer> l1,int i){
        if(i==nums.length){
            if(target==0){
                if(!l2.contains(new ArrayList<>(l1))){
                    l2.add(new ArrayList<>(l1));
                }
            }
            return;
        }
        if(target>=nums[i]){
            l1.add(nums[i]);
            powset(nums,target-nums[i],l2,l1,i);
            l1.remove(l1.size()-1);
        }
        powset(nums,target,l2,l1,i+1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> l2=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        powset(nums,target,l2,l1,0);
        return l2;
    }
}