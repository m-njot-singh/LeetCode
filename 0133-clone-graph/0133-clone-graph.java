/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public static void dfs(Node curr,Node node,Node[] vis){
        vis[node.val]=node;
        for(Node ele:curr.neighbors){
            if(vis[ele.val]==null){
                Node newnode=new Node(ele.val);
                node.neighbors.add(newnode);
                dfs(ele,newnode,vis);
                
            }
            else{
                node.neighbors.add(vis[ele.val]);
            }
        }
    }
    
    
    public Node cloneGraph(Node node) {
        
        
       if(node==null)return null;
        
        Node[] vis=new Node[1000];
        for(int i=0;i<vis.length;i++){
            vis[i]=null;
        }
        Node copy=new Node(node.val);
        vis[node.val]=copy;
        
        for(Node curr:node.neighbors){
            if(vis[curr.val]==null){
                Node newnode=new Node(curr.val);
                copy.neighbors.add(newnode);
                dfs(curr,newnode,vis);
            }
            else{
                copy.neighbors.add(vis[curr.val]);
            }
        }
        return copy;
    }
}