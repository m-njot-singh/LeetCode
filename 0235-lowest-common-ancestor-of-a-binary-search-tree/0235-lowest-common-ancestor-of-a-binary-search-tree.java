/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public static TreeNode dfs(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)return null;
        if(root==p || root==q)return root;
        TreeNode left=dfs(root.left,p,q);
        TreeNode right=dfs(root.right,p,q);
        
        if(left==null)return right;
        if(right==null)return left;
        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }
}