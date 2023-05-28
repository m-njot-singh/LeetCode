//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair{
    int first,second;
    Pair(int _first,int _second){
        this.first=_first;
        this.second=_second;
    }
}
//User function Template for Java
class Solution {
    public static void dfs(int node,int[]vis,ArrayList<ArrayList<Pair>> adj,Stack<Integer> st){
        if(vis[node]==0){
            vis[node]=1;
        }
        for(int i=0;i<adj.get(node).size();i++){
            int v=adj.get(node).get(i).first;
            if(vis[v]==0){
                dfs(v,vis,adj,st);
            }
        }
        
        st.push(node);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
		for(int i=0;i<N;i++){
		    ArrayList<Pair> temp=new ArrayList<Pair>();
		    adj.add(temp);
		}
		
		for(int i=0;i<M;i++){
		    int u=edges[i][0];
		    int v=edges[i][1];
		    int wt=edges[i][2];
		    adj.get(u).add(new Pair(v,wt));
		}
		Stack<Integer> st=new Stack<>();
		int vis[]=new int[N];
		for(int i=0;i<N;i++){
		    if(vis[i]==0){
		        dfs(i,vis,adj,st);
		    }
		}
		int[] dist=new int[N];
		for(int i=0;i<N;i++){
		    dist[i]=(int)1e9;
		}
		dist[0]=0;
		while(!st.isEmpty()){
		    int node=st.peek();
		    st.pop();
		    for(int i=0;i<adj.get(node).size();i++){
		        int v=adj.get(node).get(i).first;
		        int wt=adj.get(node).get(i).second;
		        if(dist[node]+wt<dist[v]){
		            dist[v]=dist[node]+wt;
		        }
		    }
		}
		for(int i=0;i<N;i++){
		    if(dist[i]==1e9)dist[i]=-1;
		}
		return dist;
	}
}