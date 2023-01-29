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
    List<Integer> l=new ArrayList<>();
    public  void help(TreeNode root,int k){
        if(root==null)return;
        help(root.left,k);
        l.add(root.val);
        if(l.size()==k)return ;
        help(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
       if(root==null)return 0;
       help(root,k);
       return l.get(k-1);
    }
}