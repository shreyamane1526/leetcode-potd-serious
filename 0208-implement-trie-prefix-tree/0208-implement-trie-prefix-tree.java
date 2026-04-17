class TrieNode{
    TrieNode link[]=new TrieNode[26];
    boolean flag;
    void putChar(char c,TrieNode node){
        link[c-'a']=node;
    }
    boolean containsKey(char c){
        if(link[c-'a']!=null){ 
            return true;
        }
        return false;
    }
    TrieNode getChar(char c){
        return link[c-'a'];
    }
    void setEnd(){
        flag=true;
    }
    boolean isFlag(){
        return flag;
    }
}
class Trie {
    private TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
   
    public void insert(String word) {
       TrieNode node=root; 
       for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.putChar(word.charAt(i),new TrieNode());
            }
            node=node.getChar(word.charAt(i));
       } 
       node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node=node.getChar(word.charAt(i));
        }
        if(!node.isFlag()){
            return false;
        }
        return true;
    }
    
    public boolean startsWith(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node=node.getChar(word.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */