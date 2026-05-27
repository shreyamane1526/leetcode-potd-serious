class Solution {
    public int numberOfSpecialChars(String word) {
       int upper[]=new int[26];
       int lower[]=new int[26];
       String temp=word.toLowerCase();
       for(int i=0;i<word.length();i++){
        int idx=temp.charAt(i)-'a';
        if(upper[idx]==-1){
            continue;
        }
        boolean isLowerCase=temp.charAt(i)==word.charAt(i)?true:false;
        if(isLowerCase && upper[idx]>0){
            upper[idx]=-1;
            lower[idx]=-1;
        }
        else if(isLowerCase){
            lower[idx]++;
        }
        else if(!isLowerCase){
            upper[idx]++;
        }
       }
       int c=0;
       for(int i=0;i<26;i++){
        if(lower[i]>0 && upper[i]>0){
            c++;
        }
       }
       return c;
    }
}