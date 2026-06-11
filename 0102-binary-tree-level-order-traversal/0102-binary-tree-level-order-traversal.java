/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void recur(TreeNode cur,List<List<Integer>> ans,int level){
        if(cur==null){
            return;
        }
        if(ans.size()<=level){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(cur.val);
        recur(cur.left,ans,level+1);
        recur(cur.right,ans,level+1);
    }
    void bfs(List<List<Integer>> ans,TreeNode root){
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            ans.add(new ArrayList<>());
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                ans.get(ans.size()-1).add(temp.val);
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        //recur(root,ans,0);
        bfs(ans,root);
        return ans;
    }
}