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
    public static TreeNode first=null;
    public static TreeNode second=null;
    public static TreeNode prev=null;
    public static void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        if(prev!=null && root.val<prev.val){
            if(first==null){
               first=prev;
                second=root;
            }
            else{
                second=root;
            }
             
        }
       prev=root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first=second=prev=null;
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
        
    }
}