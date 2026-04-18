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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n=queries.length;
        ArrayList<int[]> query=new ArrayList<>();
        for(int i=0;i<n;i++){
            int max=queries[i][1],num=queries[i][0];
            query.add(new int[]{max,num,i});
        }
        Arrays.sort(nums);
        int numSize=nums.length;
        int idx=0;
        int[] maxXor=new int[n];
        Arrays.fill(maxXor,-1);
        query.sort((a,b)->Integer.compare(a[0],b[0]));
        Trie trie=new Trie();
        int c=0;
        for(int i=0;i<n;i++){
            int max=query.get(i)[0];
            while(idx<numSize && nums[idx]<=max){
                c++;
                trie.insert(nums[idx]);
                idx++;
            }
            if(c==0){
                maxXor[query.get(i)[2]]=-1;
                continue;
            }
            int xorWith=query.get(i)[1];
            int xor=trie.getMaxXor(xorWith);           
            maxXor[query.get(i)[2]]=xor;
        }
        return maxXor;
    }
}