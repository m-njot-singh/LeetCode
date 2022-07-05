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
    private boolean isSymmetricHelp(TreeNode leftTree,TreeNode rightTree){
        
         if(leftTree==null && rightTree==null){
            return true;
        }
         if(leftTree==null || rightTree==null){
            return false;
        }
        if(leftTree.val!= rightTree.val)return false;
            
        return isSymmetricHelp(leftTree.left,rightTree.right) && isSymmetricHelp(leftTree.right,rightTree.left);
        
    }
    public boolean isSymmetric(TreeNode root) {
       
       return root==null || isSymmetricHelp(root.left,root.right);
    }
}