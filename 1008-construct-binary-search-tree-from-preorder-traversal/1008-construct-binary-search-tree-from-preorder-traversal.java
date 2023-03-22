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
    public static TreeNode solve(int[]preorder,int prestart,int preend,int [] inorder, int instart ,int inend,int n,Map<Integer,Integer>inmap){
        if(prestart>preend || instart>inend)return null;
        
        TreeNode root=new TreeNode(preorder[prestart]);
        int pos=inmap.get(root.val);
         int numsLeft = pos - instart;
        root.left=solve(preorder,prestart + 1, prestart + numsLeft,inorder,instart,pos-1,n,inmap);
        root.right=solve(preorder,prestart + numsLeft + 1, preend,inorder,pos+1,inend,n,inmap);
        
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder=new int[preorder.length];
        for(int i=0;i<preorder.length;i++){
            inorder[i]=preorder[i];
        }
        Arrays.sort(inorder);
        Map<Integer,Integer>inmap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inmap.put(inorder[i],i);
        }
        TreeNode ans=solve(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inorder.length,inmap);
        return ans;
    }
}