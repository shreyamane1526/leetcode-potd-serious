class Solution {
    public boolean isAnagram(String s, String t) {
        char c[]=s.toCharArray();
        char d[]=t.toCharArray();
        Arrays.sort(c);
        Arrays.sort(d);
        if(s.length()==t.length()){
            for(int i=0;i<s.length();i++){ 
            if(c[i]!=d[i]){
                System.out.println(i);
                return false;

            }
            }
            return true;
        }
        else{return false;}
    }
}