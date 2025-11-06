class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s=new HashSet<>();Set<Integer> intersection=new HashSet<>();
        if(nums1.length<=nums2.length){
        for(int num:nums1){
            s.add(num);
        }
        
        for(int num:nums2){
            if(s.contains(num)){
                intersection.add(num);
            }
        }
        }
        else{
            for(int num:nums2){
            s.add(num);
            }
        
        for(int num:nums1){
            if(s.contains(num)){
                intersection.add(num);
            }
        }
        }
        int arr[]=new int[intersection.size()];int i=0;
        for(int num:intersection){
            arr[i++]=num;
        }
        return arr;
    }
}