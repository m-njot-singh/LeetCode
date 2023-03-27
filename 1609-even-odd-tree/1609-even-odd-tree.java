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
    public boolean isEvenOddTree(TreeNode root) {
        if(root==null)return false;
        Queue<TreeNode>q=new LinkedList<TreeNode>();
        List<List<Integer>> l=new ArrayList<List<Integer>>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> ll=new ArrayList<Integer>(size);
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                ll.add(temp.val);
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
            l.add(ll);
        }
        // System.out.println(l);
        int count=0;
        for(int r=0;r<l.size();r++){
            List<Integer> w=l.get(r);
            // System.out.println(w);
            if(count==0){
                if(w.get(0)%2==0)return false;
            }
            if(count%2==0 && count>0){
                // System.out.println("yes");
                if(w.size()==1){
                    if(w.get(0)%2==0)return false;
                }
                for(int i=0;i<w.size()-1;i++){
                    // System.out.println("yes");
                    if(w.get(i)%2==0 || w.get(i+1)%2==0){
                        // System.out.println("yes");
                        return false;
                    }
                    if(w.get(i)>=w.get(i+1))return false;
                }
            }
            if(count%2!=0){
                if(w.size()==1){
                    if(w.get(0)%2!=0)return false;
                }
                for(int i=0;i<w.size()-1;i++){
                    if(w.get(i)%2!=0 || w.get(i+1)%2!=0)return false;
                    if(w.get(i)<=w.get(i+1)){
                         // System.out.println("yes");
                        return false;
                    }
                }
            }
            count++;
        }
        
        return true;
    }
}