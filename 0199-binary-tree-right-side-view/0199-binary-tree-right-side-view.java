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
    
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        if( root==null)return ans;
        
        
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> l=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
            l.add(q.peek().val);
            TreeNode temp=q.poll();
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
            }
            ans.add(l.get(l.size()-1));
        }
        
        return ans;
    }
}