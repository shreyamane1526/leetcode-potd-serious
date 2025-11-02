class Solution {
    public static void powset(int[] nums,List<List<Integer>> l2,List<Integer> l1,int i){
        
            l2.add(new ArrayList<>(l1));
            for(int j=i;j<nums.length;j++){
            if(j>i && nums[j]==nums[j-1]){
                continue;
            }
            l1.add(nums[j]);
            powset(nums,l2,l1,j+1);
            l1.remove(l1.size()-1);
        }
        // powset(nums,l2,l1,i+1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> l2=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        Arrays.sort(nums);
        powset(nums,l2,l1,0);
        return l2;
    }
}