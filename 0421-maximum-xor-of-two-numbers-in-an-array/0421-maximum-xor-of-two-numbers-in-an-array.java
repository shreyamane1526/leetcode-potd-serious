class TrieNode{
    TrieNode links[]=new TrieNode[2];
    boolean flag;
    boolean containsKey(int num){
        return links[num]!=null;
    }
    void setEnd(){
        flag=true;
    }
    boolean isFlag(){
        return flag;
    }
    void put(int num){
        links[num]=new TrieNode();
    }
    TrieNode get(int bit){
        return links[bit];
    }
}
class Trie{
    private TrieNode root;
    Trie(){
        root=new TrieNode();
    }
    void insert(int num){
        TrieNode node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(!node.containsKey(bit)){
                node.put(bit);
                node=node.get(bit);
            }
            else{
                node =node.get(bit);
            }
        }
        node.setEnd();
    }
    int getMaxXor(int num){
        TrieNode node=root;
        int maxXor=0;
        for(int i=31;i>=0;i--){ 
            int bit=(num>>i)&1;
            if(node.containsKey(1-bit)){
                maxXor=maxXor | (1<<i);
                node=node.get(1-bit);
            }
            else{
                node=node.get(bit);
            }
        }
        return maxXor;
    }
}
class Solution {
    public int findMaximumXOR(int[] arr) {
        /* Brute
        int n=arr.length;
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((arr[i]^arr[j])>max){
                    max=arr[i]^arr[j];
                }
            }
        }
        return max;
        **/
        int n=arr.length;
        int max=0;
        Trie trie=new Trie();
        for(int i=0;i<n;i++){
            trie.insert(arr[i]);
        }
        for(int i=0;i<n;i++){
            int curMax=trie.getMaxXor(arr[i]);
            max=max>curMax?max:curMax;
        }
        return max;
    }
}