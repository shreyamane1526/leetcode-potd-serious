class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> s=new HashSet<>();
        int n=sentence.length();
        int c=0;
        for(int i=0;i<n;i++){
            if(!s.contains(sentence.charAt(i))){
                s.add(sentence.charAt(i));
                c++;
            }
        }
        if(c!=26){
            return false;
        }
        return true;
    }
}