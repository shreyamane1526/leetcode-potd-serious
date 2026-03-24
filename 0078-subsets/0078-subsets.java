class Solution {
    public void findSubset(int arr[],List<List<Integer>> subset,List<Integer> temp,int i){
        if(i==arr.length){
            subset.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[i]);
        findSubset(arr,subset,temp,i+1);
        temp.remove(temp.size()-1);
        findSubset(arr,subset,temp,i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        findSubset(nums,subset,temp,0);
        return subset;
    }
}