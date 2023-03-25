/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q=new LinkedList<Node>();
        if( root==null)return root;
        q.add(root);
         q.offer(null);

        while(!q.isEmpty()){
            Node curr = q.poll();
            Node nxt = q.peek();

            if(curr == null){
                if(!q.isEmpty()){
                    q.offer(null);
                }
            } else{
                curr.next = nxt;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
        }
        return root;
    }
}