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
    void traverse(TreeNode root,List<List<Integer>> ans){
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return;
        }
        q.offer(root);
        boolean flag=true;//l->r
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> sub=new LinkedList<>();
            List<Integer> subRev=new LinkedList<>();
            for(int i=0;i<n;i++){
                TreeNode cur=q.poll();
                if(flag){
                    sub.add(cur.val);
                }
                else{
                    subRev.addFirst(cur.val);
                }
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
            if(flag){
                flag=false;
                ans.add(sub);
            }
            else{
                flag=true;
                ans.add(subRev);
            }
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans =new LinkedList<>();
        traverse(root,ans); 
        return ans;
    }
}