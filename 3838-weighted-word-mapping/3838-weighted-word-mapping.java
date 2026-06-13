class Solution {
    char getChar(int x,int wt[]){
        int start='a';
        for(int i=0;i<26;i++){
            if(wt[i]==x){
                return (char)(start+i);
            }
        }
        return 'a';
    }
    public String mapWordWeights(String[] words, int[] weights) {
        int n=words.length;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            String cur=words[i];
            int sum=0;
            int m=cur.length();
            for(int j=0;j<m;j++){
                sum+=weights[cur.charAt(j)-'a'];
            }
            ans.append(Character.toString('a'+(25-(sum%26))));
        }
        return ans.toString();
    }
}