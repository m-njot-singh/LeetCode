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
    public static List<Integer> l=new ArrayList<>();
    public static void help(TreeNode root){
        if(root==null)return;
        // if(root.left==null && root.right==null)return;
        l.add(root.val);
        help(root.left);
        help(root.right);
    }
    public void flatten(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))return;
        l.clear();
        help(root);
        root.left=null;
        root.right=null;
        for(int i=1;i<l.size();i++){
            // System.out.println(l.get(i));
            TreeNode ans=new TreeNode(l.get(i));
            root.right=ans;
            root=ans;
        }
        
    }
}