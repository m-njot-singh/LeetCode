//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,Stack<Integer> st){
        vis[node]=1;
        for(int a:adj.get(node)){
            if(vis[a]==0){
                dfs(a,adj,vis,st);
            }
        }
        st.push(node);
    }
    
    
    public static void dfsrev(int node,ArrayList<ArrayList<Integer>> adj,int[] vis){
        vis[node]=1;
        for(int a:adj.get(node)){
            if(vis[a]==0){
                dfsrev(a,adj,vis);
            }
        }
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int [] vis=new int[V];
        
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,adj,vis,st);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjrev=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjrev.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            vis[i]=0;
            for(int a:adj.get(i)){
                adjrev.get(a).add(i);
            }
        }
        int ans=0;
        while(!st.isEmpty()){
            int a=st.pop();
            if(vis[a]==0){
                ans++;
                dfsrev(a,adjrev,vis);
            }
        }
        
        return ans;
    }
}
