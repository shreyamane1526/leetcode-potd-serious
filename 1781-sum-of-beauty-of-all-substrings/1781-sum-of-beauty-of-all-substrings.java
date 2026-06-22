class Solution {
    public int beautySum(String s) {
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            
            int ch[]=new int[26];
            for(int j=i;j<n;j++){
                ch[s.charAt(j)-'a']++;
                int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                int cur=ch[k];

                if(cur>0){
                    if(max<cur){
                        max=cur;
                    }
                    if(min>cur){
                        min=cur;
                    }
                }
                
            }
            ans+=max-min;
            }
            
            
        }
        return ans;
    }
}