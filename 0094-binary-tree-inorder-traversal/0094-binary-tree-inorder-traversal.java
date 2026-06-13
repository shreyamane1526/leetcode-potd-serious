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
    void inIterative(TreeNode root,List<Integer> ans){
        Stack<TreeNode> s=new Stack<>();
        TreeNode temp=root;
        while(!s.isEmpty() || temp!=null){
            while(temp!=null){
                s.add(temp);
                temp=temp.left;
            }
            TreeNode cur=s.pop();
            ans.add(cur.val);
            temp=cur.right;
        }
    }
    void rev(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        Stack<TreeNode> s=new Stack<>();
        TreeNode temp=root.left;
        s.push(root);
        while(!s.isEmpty() || temp!=null){
            if(temp!=null){
                s.push(temp);
                temp=temp.left;
            }
            else{
                temp=s.pop();
                ans.add(temp.val);
                temp=temp.right;
            }
        }
        
    }
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
        //helper(root,ans);
        //inIterative(root,ans);
        rev(root,ans);
        return ans;
    }
}