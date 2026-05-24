class Solution {
    public String defangIPaddr(String address) {
       StringBuilder sb=new StringBuilder();
       int n=address.length();
       for(int i=0;i<n;i++){
        if(address.charAt(i)!='.' ){
            sb.append(address.charAt(i));
        }
        else{
            sb.append("[.]");
        }
       }
       return sb.toString(); 
    }
}