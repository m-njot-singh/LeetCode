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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> l=new ArrayList<>();
        q.add(root);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> templ=new ArrayList<>();
            
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(level%2==0){
                    temp.val=l.get(size-i-1);
                }
                if(temp.left!=null){
                    q.add(temp.left);
                    templ.add(temp.left.val);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                    templ.add(temp.right.val);
                }
            }
            level++;
            l=templ;
            
        }
        
        return root;
    }
}