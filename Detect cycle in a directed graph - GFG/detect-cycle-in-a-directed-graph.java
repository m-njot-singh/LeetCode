//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    
    //DFS
    
    // public static boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,int[] path){
    //     vis[node]=1;
    //     path[node]=1;
    //     for(int a:adj.get(node)){
    //         if(vis[a]==0){
    //             if(dfs(a,adj,vis,path)==true)return true;
    //             else{
    //                 path[a]=0;
    //             }
    //         }
    //         else if(vis[a]==1 && path[a]==1)return true;
    //     }
    //     path[node]=0;
    //     return false;
    // }
    
    // public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    //     // code here
        
    //     int[] vis=new int[V];
    //     int[] path=new int[V];
    //     for(int i=0;i<V;i++){
    //         if(vis[i]==0){
    //             if(dfs(i,adj,vis,path)==true)return true;
    //         }
    //     }
    //     return false;
    // }
    
    
    //BFS
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
         Queue<Integer> q=new LinkedList<>();
        int[] indegree=new int[V];
        // List<Integer> l=new ArrayList<>();
        int count=0;
        for(int i=0;i<V;i++){
            for(int a:adj.get(i)){
                indegree[a]=indegree[a]+1;
            }
        }
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            count++;
            for(int a:adj.get(node)){
                indegree[a]=indegree[a]-1;
                if(indegree[a]==0){
                    q.add(a);
                }
            }
        }
        
        if(count==V)return false;
        return true;
    }
    
}