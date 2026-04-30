class Solution {
    public int compress(char[] chars) {
        int c=0;
        if(chars.length==1){
            return 1;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<chars.length;i++){
            if(i<chars.length && i+1<chars.length && chars[i]==chars[i+1]){
                char ch=chars[i];
                int ct=1;
                while(i<chars.length && i+1<chars.length && chars[i]==chars[i+1]){
                    ct++;
                    i++;
                }
                sb.append(ch);
                sb.append(ct);
            }
            else{
                c++;
                sb.append(chars[i]);
            }
        }

        for(int i=0;i<sb.length();i++){
            chars[i]=sb.charAt(i);
        }
        return sb.length();
    }
}