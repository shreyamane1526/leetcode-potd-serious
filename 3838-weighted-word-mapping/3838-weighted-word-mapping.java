class Solution {
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