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
    public TreeNode recoverFromPreorder(String s) {
       int level=0;
        int val=0;
        int i=0;
        Stack<TreeNode> st=new Stack<>();
        while(i<s.length()){
            if(s.charAt(i)=='-'){
                level=0;
            while(s.charAt(i)=='-'){
                level++;
                i++;
            }
            }
            if(s.charAt(i)!='-' && i<s.length()){
                val=0;
            while(i<s.length()&& s.charAt(i)!='-'){
                val=val*10+(s.charAt(i)-'0');
                i++;
            }
            }
            while(st.size()>level)st.pop();
            TreeNode node=new TreeNode(val);
            if(!st.isEmpty()){
                if(st.peek().left==null){
                    st.peek().left=node;
                }
                else{
                    st.peek().right=node;
                }
                
            }
            st.push(node);
        }
        while(st.size()>1){
            st.pop();
        }
        return st.pop();
    }
}