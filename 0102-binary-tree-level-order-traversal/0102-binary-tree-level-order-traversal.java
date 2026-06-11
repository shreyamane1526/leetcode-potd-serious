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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        recur(root,ans,0);
        return ans;
    }
}