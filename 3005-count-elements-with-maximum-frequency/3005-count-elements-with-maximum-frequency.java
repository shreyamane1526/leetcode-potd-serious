class Solution {
    public int maxFrequencyElements(int[] nums) {
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
    }
}