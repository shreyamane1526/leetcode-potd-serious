class Solution {
    boolean hashing(String s,String t){
        int n1=s.length();int n2=t.length();
        if(n1!=n2){
            return false;
        }
        HashMap<Character,Integer> hm1=new HashMap<>();
        HashMap<Character,Integer> hm2=new HashMap<>();
        for(int i=0;i<n1;i++){
            hm1.put(s.charAt(i),hm1.getOrDefault(s.charAt(i),0)+1);
            hm2.put(t.charAt(i),hm2.getOrDefault(t.charAt(i),0)+1);
        }    
        for(Map.Entry<Character,Integer> entry:hm1.entrySet()){
            int val1=entry.getValue();
            char key=entry.getKey();
            if(!hm2.containsKey(key) || hm2.get(key)!=val1){
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram(String s, String t) {
        /*
        int ch[]=new int[26];
        int ch2[]=new int[26];
        s=s.toLowerCase();
        t=t.toLowerCase();
        
        for(int i=0;i<s.length();i++){
            ch[s.charAt(i)-'a']++;
            ch2[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(ch[i]!=ch2[i]){
                return false;
            }
        }
        return true;
        */
        return hashing(s,t);
    }
}