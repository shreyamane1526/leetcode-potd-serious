class Solution {
    public String reverseWords(String s) {
        ArrayList<String> li=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            while(i<s.length() && s.charAt(i)==' '){
                i++;
            }
            StringBuilder sb=new StringBuilder();
            while(i<s.length() && s.charAt(i)!=' '){
                sb.append(s.charAt(i));
                i++;
            }
            if(!sb.isEmpty()){
                li.add(sb.toString());
            }
        }
        StringBuilder ans=new StringBuilder();
        for(int i=li.size()-1;i>=0;i--){
            if(i!=li.size()-1 ){
                ans.append(" ");
            }
            ans.append(li.get(i));
            // if(i!=li.size()-1 || i!=0){
            //     ans.append(" ");
            // }
            
        }
        
        return ans.toString();
    }
}