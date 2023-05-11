//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int node;
    int root;
    Pair(int _node,int _root){
        this.node=_node;this.root=_root;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    
    // bfs
    
    // public static boolean bfs(int src,int v,ArrayList<ArrayList<Integer>> adj,int[] vis){
    //     Queue<Pair> q=new LinkedList<>();
    //     vis[src]=1;
    //     q.add(new Pair(src,-1));
    //     while(!q.isEmpty()){
    //         int node=q.peek().node;
    //         int root=q.peek().root;
    //         q.remove();
    //         for(int adjacent:adj.get(node)){
    //             if(vis[adjacent]==0){
    //                 vis[adjacent]=1;
    //                 q.add(new Pair(adjacent,node));
    //             }
    //             else if(root!=adjacent){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
        
    // }
    
    
    //dfs
    
    public static boolean dfs(int src,int parent,int v,ArrayList<ArrayList<Integer>> adj,int[] vis){
        vis[src]=1;
        for(int adjacent:adj.get(src)){
            if(vis[adjacent]==1 ){
                if(adjacent!=parent){
                    return true;
                }
            }
            else{
                if(dfs(adjacent,src,v,adj,vis)==true)
                return true;
            }
            
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
               if(dfs(i,-1,V,adj,vis))return true;
            }
        }
        return false;
    }
}