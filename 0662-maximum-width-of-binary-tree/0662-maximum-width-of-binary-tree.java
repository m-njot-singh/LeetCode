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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
        int ans=0;
        int first=0;
        int last=0;
        q.add(new Pair(root,1));
        while(!q.isEmpty()){
           first=0;
            last=0;
            int size=q.size();
            // System.out.println("size"+"="+size);
            for(int i=0;i<size;i++){
                
                int j=q.peek().getValue();
                if(i==0){
                    first=q.peek().getValue();
                    // System.out.println("first"+"="+first);
                }
                if(i==size-1){
                    last=q.peek().getValue();
                    // System.out.println("last"+"="+last);
                }
                
                TreeNode temp=q.peek().getKey();
                // System.out.println(temp.val);
                q.remove();
                if(temp.left!=null){
                    q.add(new Pair(temp.left,2*j));
                    // System.out.println(q.peek().getKey().val+","+q.peek().getValue());
                }
                if(temp.right!=null){
                    q.add(new Pair(temp.right,2*j+1));
                    // System.out.println(q.peek().getKey().val+","+q.peek().getValue());
                }
                j++;
            }
            ans=Math.max(ans,(last-first)+1);
        }
        return ans;
    }
}