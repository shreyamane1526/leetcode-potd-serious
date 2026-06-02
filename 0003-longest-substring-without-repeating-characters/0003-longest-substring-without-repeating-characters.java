class Solution {
    int brute(String s,int n){
        int max=0;
        for(int i=0;i<n;i++){
            Set<Character> set=new HashSet<>();
            for(int j=i;j<n;j++){
                if(set.contains(s.charAt(j))){
                    break;
                }
                set.add(s.charAt(j));
                max=Math.max(max,j-i+1);
            }
        }
        return max;
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int n=s.length();
        return brute(s,n);
    }
}