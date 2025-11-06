class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> s=new TreeSet<>();
        for(int num:nums){
            s.add(num);
        }
        int i=0;
        for(int num:s){
            nums[i++]=num;
        }
        return s.size();
    }
}