class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s=new HashSet<>(); 
        if(nums2.length<=nums1.length){
            ArrayList<Integer> li=new ArrayList<>();
            for(int nums:nums1){li.add(nums);}
            for(int i=0;i<nums2.length;i++){
                if(li.contains(nums2[i])){
                    s.add(nums2[i]);
                }
            }
        }
        else{
            ArrayList<Integer> li=new ArrayList<>();
            for(int nums:nums2){li.add(nums);}
            for(int i=0;i<nums1.length;i++){
                if(li.contains(nums1[i])){
                    s.add(nums1[i]);
                }
            }
        }
        int ans[]=new int[s.size()];
        int i=0;
        for(int num:s){
            ans[i++]=num;
        }
        return ans;
    }
}