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
    int preOrder(TreeNode root){
        int l=0,r=0;
        if(root.left!=null){
            l=preOrder(root.left)+1;
        }
        if(root.right!=null){ 
            r=preOrder(root.right)+1;
        }
        return Math.max(l,r);
    }
    int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=height(root.left);
        int r=height(root.right);
        return 1+Math.max(l,r);
    }
    public int maxDepth(TreeNode root) {
        /*
        if(root==null){
            return 0;
        }
        return preOrder(root)+1;
        */
        return height(root);
    }
}