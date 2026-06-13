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
    boolean check(TreeNode x,TreeNode y){
        if(x==null && y==null){
            return true;
        }
        else if((x==null && y!=null) || (x!=null && y==null) || (x.val!=y.val)){
            return false;
        }
        if(!check(x.left,y.right)){
            return false;
        }
        if(!check(x.right,y.left)){
            return false;
        }
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
}