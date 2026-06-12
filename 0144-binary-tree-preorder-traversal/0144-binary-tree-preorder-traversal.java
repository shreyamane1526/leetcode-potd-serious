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
    void preIterative(TreeNode root,List<Integer> ans){
        Stack<TreeNode> s=new Stack<>();
        TreeNode temp=root;
        if(root!=null){ 
            s.add(root);
        }
        while(!s.isEmpty()){
            TreeNode cur=s.pop();
            ans.add(cur.val);
            if(cur.right!=null){
                s.add(cur.right);
            }
            if(cur.left!=null){
                s.add(cur.left);
            }
        }
    }
    void preHelper(TreeNode cur,List<Integer> preOrderList){
        if(cur==null){
            return;
        }
        preOrderList.add(cur.val);
        preHelper(cur.left,preOrderList);
        preHelper(cur.right,preOrderList);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderList=new ArrayList<>();
        //preHelper(root,preOrderList);
        preIterative(root,preOrderList);
        return preOrderList;
    }
}