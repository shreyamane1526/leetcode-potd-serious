class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> li=new ArrayList<>();
        int one=1;
        for(int i=0;i<nums.length;i++){
            int x=Math.abs(nums[i])-1;
            if(x==0){
                one=-1;
            }
            else if(nums[x]>0){
                nums[x]=-nums[x];
            }
        }
        if(one>0){
            li.add(1);
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]>0){
                li.add(i+1);
            }
        }
        return li;
    }
}