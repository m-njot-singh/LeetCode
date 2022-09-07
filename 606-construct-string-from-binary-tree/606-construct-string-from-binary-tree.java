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
     StringBuilder str = new StringBuilder();
    private void t(TreeNode root){
        if(root==null)return;
        if(root.left==null && root.right==null){
            str.append(root.val);
            return;
        }
        str.append(root.val);
        str.append('(');
        if(root.left!=null){
            t(root.left);
            str.append(')');
        }
        else{
            str.append(')');
        }
        if(root.right!=null){
            str.append('(');
            t(root.right);
            str.append(')');
        }
    }
    public String tree2str(TreeNode root) {
        str = new StringBuilder();
        t(root);
        return str.toString();
    }
}