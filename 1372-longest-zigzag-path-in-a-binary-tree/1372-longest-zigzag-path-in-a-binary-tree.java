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
    public static class pair{
        int forwardslop=-1;
        int backwardslop=-1;
        int maxlen=0;
    }
    public static pair help(TreeNode root){
        if(root==null)return new pair();
        pair left=help(root.left);
        pair right=help(root.right);
        pair myans=new pair();
        myans.maxlen=Math.max(Math.max(left.maxlen,right.maxlen),Math.max(left.backwardslop,right.forwardslop)+1);
        myans.forwardslop=left.backwardslop+1;
        myans.backwardslop=right.forwardslop+1;
        return myans;
    }
    public int longestZigZag(TreeNode root) {
        pair ans=help(root);
        return ans.maxlen;
    }
}