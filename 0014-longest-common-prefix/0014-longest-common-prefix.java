class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder p=new StringBuilder(strs[0]);
        for(int i=1;i<strs.length;i++){
            // if(p.toString().contains(strs[i])){
            //     p=new StringBuilder(strs[i]);
            // }
            // else{
                int j=0;
                for( j=0;j<p.length() && j<strs[i].length();j++){
                    if(strs[i].charAt(j)!=p.charAt(j)){
                        break;
                    }
                }
                p.delete(j,p.length());
           // }
            if(p==new StringBuilder("")){
                return "";
            }
        }
        return p.toString();
    }
}