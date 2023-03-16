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
    public static TreeNode solve(int[] postorder,int poststart,int postend,int [] inorder,int instart,int inend,int n,Map<Integer,Integer>inmap){
        if(poststart<postend || instart>inend)return null;
        TreeNode root=new TreeNode(postorder[poststart]);
        int pos=inmap.get(root.val);
        int index=instart;
        root.left=solve(postorder,postend+pos-instart-1,postend,inorder,instart,pos-1,n,inmap);
        root.right=solve(postorder,poststart-1,postend+pos-instart,inorder,pos+1,inend,n,inmap);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer>inmap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inmap.put(inorder[i],i);
        }
        
        TreeNode ans=solve(postorder,postorder.length-1,0,inorder,0,inorder.length-1,inorder.length,inmap);
            
            return ans;
    }
}