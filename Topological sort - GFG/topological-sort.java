//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    
    // DFS
    
    // public static void dfs(int node,int[] vis,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
    //     if(vis[node]==0){
    //         vis[node]=1;
    //     }
    //     for(int a:adj.get(node)){
    //         if(vis[a]==0){
    //             dfs(a,vis,st,adj);
    //         }
    //     }
    //     st.push(node);
    // }
    
    
    // static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    // {
    //     // add your code here
    //     Stack<Integer> st=new Stack<>();
    //     int[] ans=new int[V];
    //     int[]vis=new int[V];
    //     for(int i=0;i<V;i++){
    //         if(vis[i]==0){
    //             dfs(i,vis,st,adj);
    //         }
    //     }
    //     for(int i=0;i<V;i++){
    //         ans[i]=st.pop();
    //     }
    //     return ans;
    // }
    
    
    
    // BFS
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Queue<Integer> q=new LinkedList<>();
        int[] indegree=new int[V];
        List<Integer> l=new ArrayList<>();
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
            l.add(node);
            for(int a:adj.get(node)){
                indegree[a]=indegree[a]-1;
                if(indegree[a]==0){
                    q.add(a);
                }
            }
        }
        
        
        
        
        int [] ans=new int[V];
        for(int i=0;i<V;i++){
            ans[i]=l.get(i);
        }
        return ans;
    }
}
