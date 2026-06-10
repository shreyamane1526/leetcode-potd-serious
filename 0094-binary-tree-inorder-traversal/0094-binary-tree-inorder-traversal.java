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
    void helper(TreeNode cur,List<Integer> inOrderList){
        if(cur==null){
            return;
        }
        helper(cur.left,inOrderList);
        inOrderList.add(cur.val);
        helper(cur.right,inOrderList);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        helper(root,ans);
        return ans;
    }
}