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
    static int ans=0;
    public static void dfs(TreeNode root,long sum){
        if(root==null)return;
        if(root!=null){
            if(root.val==sum){
                ans++;
            }
            dfs(root.left,sum-root.val);
            dfs(root.right,sum-root.val);
        }
        
    }
    public int pathsumhelper(TreeNode root,int targetSum){
         if(root==null)return 0;
        
        dfs(root,targetSum);
        pathsumhelper(root.left,targetSum);
        pathsumhelper(root.right,targetSum);
        return ans;
    }
    public int pathSum(TreeNode root, int targetSum) {
       ans=0;
        pathsumhelper(root,targetSum);
        return ans;
        
    }
}