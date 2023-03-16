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
    public static int solve(TreeNode root,HashMap<Integer,Integer> map,int sum){
        if(root==null)return 0;
        // if(root.left==null && root.right==null)return 0;
        int left=solve(root.left,map,sum);
        int right=solve(root.right,map,sum);
        sum=root.val+left+right;
        // System.out.println(sum);
        if(map.containsKey(sum)){
            map.put(sum,map.get(sum)+1);
        }
        else{
            map.put(sum,1);
        }
        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> l=new ArrayList<Integer>();
        int aq=solve(root,map,0);
        int maxfreq=Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> i: map.entrySet()){
           maxfreq=Math.max(maxfreq,i.getValue());
        }
        for(Map.Entry<Integer,Integer> j:map.entrySet()){
            if(j.getValue()==maxfreq){
                l.add(j.getKey());
            }
        }
        int [] ans=new int[l.size()];
        for(int i=0;i<l.size();i++){
            ans[i]=l.get(i);
        }
        
        return  ans;
    }
}