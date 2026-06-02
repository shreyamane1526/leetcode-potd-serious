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
    int slidingwindow(String s,int n){
        int r=0,l=0;
        int ch[]=new int[256];
        Arrays.fill(ch,-1);
        int max=0;
        for(l=0;l<n;l++){
            if(ch[s.charAt(l)-'a']!=-1){
                r=ch[s.charAt(l)-'a'];
            }
            ch[s.charAt(l)-'a']=l;
            max=Math.max(max,l-r+1);
        }
        return max;
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int n=s.length();
        return brute(s,n);
    }
}