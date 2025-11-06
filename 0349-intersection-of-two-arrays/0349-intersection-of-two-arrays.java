class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s=new HashSet<>();
        for(int num:nums1){
            s.add(num);
        }
        Set<Integer> intersection=new HashSet<>();
        for(int num:nums2){
            if(s.contains(num)){
                intersection.add(num);
            }
        }
        int arr[]=new int[intersection.size()];int i=0;
        for(int num:intersection){
            arr[i++]=num;
        }
        return arr;
    }
}