class Solution {
    public boolean sorting(int arr[]){
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                return true;
            }
        }
        return false;
    }
    public boolean hashing(int arr[]){
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i])){
                return true;
            }
            else{
                hm.put(arr[i],1);
            }
        }
        return false;
    }
    public boolean containsDuplicate(int[] arr) {
        //return sorting(arr);
        return hashing(arr);
    }
}