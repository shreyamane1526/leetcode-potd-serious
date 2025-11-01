class Solution {
    public static void subsequence(int nums[],int target,int i,List<List<Integer>> l2, List<Integer> l1){
                if(target==0){
                    l2.add(new ArrayList<>(l1));
                    return;
                }           
            for(int j=i;j<nums.length;j++){
                if(j>i  && nums[j]==nums[j-1]){continue;}
                if(target>=nums[j]){
                    l1.add(nums[j]);
                    subsequence(nums,target-nums[j],j+1,l2,l1);
                     l1.remove(l1.size()-1);
                }
                else if(target<nums[j]){break;}
            }
            
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> l2=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        Arrays.sort(nums);
        subsequence(nums,target,0,l2,l1);
        return l2;
    }
}