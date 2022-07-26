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
    
    List<String> newList=new ArrayList<String>();
    
    public void path(TreeNode root, String s){
         if(root==null){
            return ;
        }
        if(root.left==null && root.right==null){
            newList.add(s+root.val);
            return;
        }
        else{
            s=s+root.val+"->";
            System.out.println(s);
            path(root.left,s);
            path(root.right,s);
            
        }
        
    }
    public List<String> binaryTreePaths(TreeNode root1) {
        path(root1,"");
    
       
        return newList;
    }
}