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
    public static void preorder(TreeNode root,List<Integer> preorder){
        if(root==null)return;
        preorder(root.left,preorder);
        preorder.add(root.val);
        preorder(root.right,preorder);
    }
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> l=new ArrayList<>();
        preorder(root,l);
        l.add(val);
        int[] ans=new int[l.size()];
        for(int i=0;i<l.size();i++){
            ans[i]=l.get(i);
        }
        TreeNode arr=new TreeNode();
        arr=help(ans,0,ans.length);
        return arr;
    }
}