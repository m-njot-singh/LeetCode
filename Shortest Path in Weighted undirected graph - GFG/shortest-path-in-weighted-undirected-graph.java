//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int dist;
    int node;
    Pair(int _dist,int _node){
        this.dist=_dist;
        this.node=_node;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        int dis[]=new int[n+1];
        int parent[]=new int[n+1];
        for(int i=1;i<=n;i++){
            dis[i]=(int)1e9;
            parent[i]=i;
        }
        // System.out.println(adj);
        dis[1]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.dist-y.dist);
        pq.add(new Pair(0,1));
        while(pq.size()!=0){
            Pair itr=pq.peek();
            int node=itr.node;
            int dist=itr.dist;
            pq.remove();
            for(Pair a:adj.get(node)){
                int adjnode=a.dist;
                int w=a.node;
                if(dist+w<dis[adjnode]){
                    dis[adjnode]=dist+w;
                    pq.add(new Pair(w+dist,adjnode));
                    parent[adjnode]=node;
                }
            }
        }
        
        List<Integer> ans=new ArrayList<>();
        if(dis[n]==(int)1e9){
            ans.add(-1);
            return ans;
        }
        
        int node=n;
        
        while(parent[node]!=node){
            ans.add(node);
            node=parent[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
        
    }
}