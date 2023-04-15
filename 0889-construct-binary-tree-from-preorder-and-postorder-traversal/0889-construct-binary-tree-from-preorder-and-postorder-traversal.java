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
    public static TreeNode Tree(int[]preorder,int prestart,int preend,int[]postorder,int poststart,int postend){
        
        if(prestart>preend )return null;
        TreeNode root=new TreeNode(preorder[prestart]);
        // System.out.println(postmap.get(preorder[premap.get(root.val)+1]));
        if(prestart==preend)return root;
        int idx=poststart;
        while(postorder[idx]!=preorder[prestart+1])idx++;
        int total=idx-poststart+1;
        root.left=Tree(preorder,prestart+1,prestart+total,postorder,poststart,idx);
        root.right=Tree(preorder,prestart+total+1,preend,postorder,idx+1,postend-1);
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return Tree(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }
}