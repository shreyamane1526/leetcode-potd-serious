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
    void helper(TreeNode cur,List<Integer> postOrderList){
        if(cur==null){
            return;
        }
        helper(cur.left,postOrderList);
        helper(cur.right,postOrderList);
        postOrderList.add(cur.val);
    }
    void postIterative(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            ans.add(temp.val);       
            if(temp.left!=null){
                s.push(temp.left);
            }
            if(temp.right!=null){
                s.push(temp.right);
            }
        }
        reverse(ans);
    }
    void reverse(List<Integer> ans){
        int j=ans.size()-1,i=0;
        while(i<j){
            int temp=ans.get(i);
            ans.set(i,ans.get(j));
            ans.set(j,temp);
            i++;
            j--;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        //helper(root,ans);
        postIterative(root,ans);
        return ans;
    }
}