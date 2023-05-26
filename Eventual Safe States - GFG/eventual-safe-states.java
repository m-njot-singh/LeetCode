//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean dfs(int node,int[]vis,int[]path,List<List<Integer>> adj,int[] check){
        if(vis[node]==0){
            vis[node]=1;
            path[node]=1;
        }
        for(int a:adj.get(node)){
            if(vis[a]==0){
                if(dfs(a,vis,path,adj,check)==false)return false;
            }
            else if(vis[a]==1 && path[a]==1 )return false;
        }
        check[node]=1;
        path[node]=0;
        return true;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        List<Integer> ans=new ArrayList<>();
        int[] vis=new int[V];
        int[] path=new int[V];
        int[] check=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,vis,path,adj,check);
            }
        }
        for(int i=0;i<V;i++){
            if(check[i]==1)ans.add(i);
        }
        return ans;
        
    }
}
