class Solution {
    public static void rec(int[] nums, List<List<Integer>> l2,int i){
        if(i==nums.length){
            List<Integer> l1=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                l1.add(nums[j]);
            }
            l2.add(new ArrayList<>(l1));return;
        }
        for(int j=i;j<nums.length;j++){
            swap(j,i,nums);
            rec(nums,l2,i+1);
             swap(j,i,nums);
        }
    }
    public static void swap(int a,int b,int[] nums){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> l2=new ArrayList<>();
       rec(nums,l2,0);return l2;
    }
}


//appeoach 2 
// class Solution {
//     public static void permu( List<List<Integer>> l2, List<Integer> l1,int[] nums,boolean freq[]){
//         if(l1.size()==nums.length){
//             l2.add(new ArrayList<>(l1));
//             return;
//         }
//         for(int j=0;j<nums.length;j++){
//             if(freq[j])continue;
//             freq[j]=true;
//             l1.add(nums[j]);
//             permu(l2,l1,nums,freq);
//             l1.remove(l1.size()-1);
//             freq[j]=false;
//         }
//     }
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> l2=new ArrayList<>();
//         List<Integer> l1=new ArrayList<>();
//         boolean freq[]=new boolean[nums.length];
//         permu(l2,l1,nums,freq);
//         return l2;
//     }
// }