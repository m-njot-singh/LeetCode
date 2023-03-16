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
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> q=new LinkedList<Pair<TreeNode,Integer>>();
        int sum=0;
        int count=0;
        q.add(new Pair<>(root,0));
        while(!q.isEmpty()){
            int flag=q.peek().getValue();
            TreeNode temp=q.poll().getKey();
            if(temp.left!=null){
                q.add(new Pair<>(temp.left,1));
            }
            if(temp.right!=null){
                q.add(new Pair<>(temp.right,0));
            }
            if(temp.left==null && temp.right==null && flag==1){
                sum+=temp.val;
            }
        }
        return sum;
    }
}