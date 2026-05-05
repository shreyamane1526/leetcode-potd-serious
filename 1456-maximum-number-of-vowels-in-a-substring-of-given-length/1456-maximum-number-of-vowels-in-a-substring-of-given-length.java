class Solution {
    public boolean isVowel(char c){
        if(c=='a' ||c=='e' ||c=='i' ||c=='o' ||c=='u'){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int left=0;
        int n=s.length();
        int max=0;
        int cur=0;
        for(int r=0;r<n;r++){
            if(isVowel(s.charAt(r))){
                cur++;
            }
            if(r-left+1==k){
                max=Math.max(max,cur);
                if(isVowel(s.charAt(left))){
                    cur--;
                }  
                left++;          
            }
        }
        return max;
    }
}