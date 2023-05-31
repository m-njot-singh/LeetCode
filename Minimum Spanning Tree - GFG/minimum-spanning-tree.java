//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int first;
    int second;
    Pair(int _first,int _second){
        this.first=_first;
        this.second=_second;
    }
}


class trio{
    int first;
    int second;
    int third;
    trio(int _first,int _second,int _third){
        this.first=_first;
        this.second=_second;
        this.third=_third;
    }
}


class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here.
	    ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    
	        for(int i=0;i<E;i++){
	            int u=edges[i][0];
	            int v=edges[i][1];
	            int w=edges[i][2];
	            adj.get(u).add(new Pair(v,w));
	            adj.get(v).add(new Pair(u,w));
	        }
	    
	    int vis[]=new int[V];
	    
	    PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.first-y.first);
	    pq.add(new Pair(0,0));
	    int sum=0;
	    
	    while(!pq.isEmpty()){
	        Pair it=pq.peek();
	        pq.remove();
	        int dist=it.first;
	        int node=it.second;
	        
	        if(vis[node]==1)continue;
	        vis[node]=1;
	        sum+=dist;
	        
	        for(Pair a:adj.get(node)){
	            int adjnode=a.first;
	            int wt=a.second;
	            vis[node]=1;
	            if(vis[adjnode]==0){
	                pq.add(new Pair(wt,adjnode));
	            }
	        }
	        
	    }
	    
	    return sum;
	}
}