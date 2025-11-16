class Solution {
    public int findKthPositive(int[] arr, int k) {
        //brute
        int missing=1;
        int ct=0;
        for(int i=0;i<arr.length;i++){
            if(k==ct){return missing;}
            if(arr[i]!=missing){
                while(arr[i]!=missing){
                    missing++;ct++;
                    if(k==ct){return missing-1;}
                }
            }          
                missing++;        
            
        }
        while(k!=ct){
            missing++;ct++;

        }
        return missing-1;
    }
}