//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    // public static boolean check(int i,ArrayList<ArrayList<Integer>>adj,int[] color){
    //     Queue<Integer> q=new LinkedList<>();
    //     q.add(i);
    //     color[i]=0;
        
    //     while(!q.isEmpty()){
    //         int node=q.poll();
    //         for(int a:adj.get(node)){
    //             if(color[a]==-1){
    //                 color[a]=1-color[node];
    //                 q.add(a);
    //             }
    //             else if(color[a]==color[node]){
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    
    public static boolean check(int i,ArrayList<ArrayList<Integer>> adj,int[] color){
        if(color[i]==-1){
            color[i]=0;
        }
        for(int a:adj.get(i)){
            if(color[a]==-1){
                color[a]=1-color[i];
                if(check(a,adj,color)==false)return false;
            }
            else if(color[i]==color[a]){
                return false;
            }
            
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int color[]=new int[V];
        for(int i=0;i<V;i++){
            color[i]=-1;
        }
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(check(i,adj,color)==false){
                    return false;
                }
            }
        }
        return true;
    }
}