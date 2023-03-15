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
    static int temp_sum;
    public static void help(TreeNode root,int temp){
         if( root==null)return ;
        temp*=10;
        temp+=root.val;
        
        if(root.left==null && root.right==null){
            temp_sum+=temp;
            return;
        }
        help(root.left,temp);
        help(root.right,temp);
    }
    public int sumNumbers(TreeNode root) {
       temp_sum=0;
        int temp=0;
        help(root,temp);
        return temp_sum;
    }
}