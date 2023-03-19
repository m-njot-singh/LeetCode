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
    public static TreeNode help(int[] nums,int nstart ,int nend){
        if(nstart>=nend)return null;
        int pos=nstart;
        int max=nums[nstart];
        for(int i=nstart+1;i<nend;i++){
            if(nums[i]>max){
                max=nums[i];
                pos=i;
            }
        }
        TreeNode root=new TreeNode(max);
        root.left=help(nums,nstart,pos);
        root.right=help(nums,pos+1,nend);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode ans=new TreeNode();
        ans=help(nums,0,nums.length);
        return ans;
    }
}