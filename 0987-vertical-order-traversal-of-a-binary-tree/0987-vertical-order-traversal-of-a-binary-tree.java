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

class tuple{
    TreeNode node;
    int row;
    int col;
    tuple(TreeNode _node,int _row,int _col){
        this.node=_node;
        this.row=_row;
        this.col=_col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<tuple> q=new LinkedList<>();
        q.add(new tuple(root,0,0));
        while(!q.isEmpty()){
            tuple it=q.remove();
            TreeNode node=it.node;
            int row=it.row;
            int col=it.col;
            
            if(!map.containsKey(row)){
                map.put(row,new TreeMap<>());
            }
            if(!map.get(row).containsKey(col)){
                map.get(row).put(col,new PriorityQueue<>());
            }
            map.get(row).get(col).add(node.val);
            if(node.left!=null){
                q.add(new tuple(node.left,row-1,col+1));
            }
            if(node.right!=null){
                q.add(new tuple(node.right,row+1,col+1));
            }
        }
        
        List<List<Integer>> ans=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> it:map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> itt:it.values()){
                while(!itt.isEmpty()){
                    ans.get(ans.size()-1).add(itt.poll());
                }
            }
        }
        
        return ans;
        
    }
}