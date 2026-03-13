class Solution {
    public int maxFrequencyElements(int[] nums) {
        //Using HashMap
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault((nums[i]),0)+1);
        }
        int maxFreq=0;
        int ans=0;
        for(int value:hm.values()){
            if(value>maxFreq){
                maxFreq=value;
                ans=maxFreq;
            }
            else if(value==maxFreq){
                ans+=value;
            }
        }
        return ans;






        /******Number Hashing App
int freq[]=new int[100];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]-1]++;
        }
        int maxFreqEle=-1;
        int maxFreq=0;
        int ans=0;

        for(int i=0;i<100;i++){
            if(freq[i]>maxFreq){
                maxFreq=freq[i];
                maxFreqEle=i+1;
                ans=maxFreq;
            }
            else if(freq[i]==maxFreq){
                ans+=maxFreq;
            }
        
        }
        return ans;
*****/
    }
}
