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
    boolean brute(TreeNode root){
        if(root==null){
            return true;
        }
        int l=hbrute(root.left);
        int r=hbrute(root.right);
        if(Math.abs(l-r)>1){
            return false;
        }
        return brute(root.left)&&brute(root.right);
    }
    int hbrute(TreeNode cur){
        if(cur==null){
            return 0;
        }
        int l=hbrute(cur.left);
        int r=hbrute(cur.right);
        return 1+Math.max(l,r);
    }
    int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=height(root.left);
        if(l==-1){
            return -1;
        }
        int r=height(root.right);
        if(r==-1){
            return -1;
        }
        if(Math.abs(l-r)>1){
            return -1;
        }
        return 1+Math.max(l,r);
    }
    public boolean isBalanced(TreeNode root) {
        //return height(root)!=-1;
        return brute(root);
    }
}