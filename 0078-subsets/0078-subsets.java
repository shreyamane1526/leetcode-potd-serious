class Solution {
    public static void powset(List<List<Integer>> l2,List<Integer> l1,int i,int nums[]){
        if(i==nums.length){
            l2.add(new ArrayList<>(l1));
            return;
        }
        l1.add(nums[i]);
        powset(l2,l1,i+1,nums);
        l1.remove(l1.size()-1);
        powset(l2,l1,i+1,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> l2=new ArrayList<>();
       List<Integer> l1=new ArrayList<>();
       powset(l2,l1,0,nums);
       return l2;
    }
}