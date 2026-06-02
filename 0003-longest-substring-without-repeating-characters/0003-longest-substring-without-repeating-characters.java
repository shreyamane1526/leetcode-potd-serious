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
        HashMap<Character,Integer> hm=new HashMap<>();
        int max=0;
        for(l=0;l<n;l++){
            if(hm.containsKey(s.charAt(l)) && hm.get(s.charAt(l))>=r){
                r=hm.get(s.charAt(l))+1;               
            }
            hm.put(s.charAt(l),l);
            max=Math.max(max,l-r+1);
        }
        return max;
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int n=s.length();
      
        //return brute(s,n);
        return slidingwindow(s,n);
    }
}