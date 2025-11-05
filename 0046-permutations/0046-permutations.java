class Solution {
    public static void permu( List<List<Integer>> l2, List<Integer> l1,int[] nums,boolean freq[]){
        if(l1.size()==nums.length){
            l2.add(new ArrayList<>(l1));
            return;
        }
        for(int j=0;j<nums.length;j++){
            if(freq[j])continue;
            freq[j]=true;
            l1.add(nums[j]);
            permu(l2,l1,nums,freq);
            l1.remove(l1.size()-1);
            freq[j]=false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l2=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        boolean freq[]=new boolean[nums.length];
        permu(l2,l1,nums,freq);
        return l2;
    }
}