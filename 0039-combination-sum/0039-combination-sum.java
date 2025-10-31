class Solution {
    public static void powset(int[] nums,List<List<Integer>> l2,List<Integer> l1,int target,int i){
        if(i==nums.length){
            if(target==0){
                l2.add(new ArrayList<>(l1));
            }
            return;
        }
        if(target>=nums[i] ){
            l1.add(nums[i]);
            powset(nums,l2,l1,target-nums[i],i);
            l1.remove(l1.size()-1);
        }
        powset(nums,l2,l1,target,i+1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> l2=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        powset(nums,l2,l1,target,0);
        return l2;
    }
}