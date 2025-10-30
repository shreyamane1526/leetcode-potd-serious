class Solution {
    public void powfun(int[] nums,int i,List<List<Integer>> li,List<Integer> seq) {
        if(i==nums.length){
            li.add(new ArrayList<>(seq));
            return;
        }
        seq.add(nums[i]);
        powfun(nums,i+1,li,seq);
        seq.remove(seq.size()-1);
        powfun(nums,i+1,li,seq);
       
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> li=new ArrayList<>();
       List<Integer> seq=new ArrayList<>();
     powfun(nums,0,li,seq);
     return li;
    }
}