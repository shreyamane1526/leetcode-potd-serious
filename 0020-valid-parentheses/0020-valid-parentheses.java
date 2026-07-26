class Solution {
    public boolean isValid(String s) {
        boolean ans=false;;
        Stack<Character> p=new Stack<>();
        if(s.length()==1){
            return false;
        }
        for(int i=0;i<s.length();i++){
            char m=s.charAt(i);
           if(isOpen(m)){p.push(m);}
           else{
            if(p.isEmpty()){
            return false;}
            char prev=p.pop();
            if(parent(prev,m)==false){return false;}
           
        }}
        if(p.isEmpty()){return true;}
        return false;
    }
    private boolean isOpen(char m){
     if(m=='(' || m=='{' || m=='['){return true;}return false;
    }
   
    private boolean parent(char prev,char next){ 
        if((prev=='(' && next==')') || (prev=='[' && next==']') || (prev=='{' && next=='}')){return true;}
        return false;
    }
}