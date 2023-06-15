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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int max=Integer.MIN_VALUE;
        int sum=0;
        int level=0;
        int ans=0;
        while(!q.isEmpty()){
            int l=q.size();
            sum=0;
            level++;
            for(int i=0;i<l;i++){
                TreeNode temp=q.peek();
                q.remove();
                sum+=temp.val;
                if(i==l-1){
                    if(max<sum){
                        max=sum;
                        ans=level;
                    }
                }
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
        }
        return ans;
    }
}