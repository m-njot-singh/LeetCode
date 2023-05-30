//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

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
class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=flights.length;
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        
        int dis[]=new int[n];
        for(int i=0;i<n;i++){
            dis[i]=(int)1e9;
        }
        dis[src]=0;
        
        Queue<trio> q=new LinkedList<>();
        q.add(new trio(0,src,0));
        
        
        while(!q.isEmpty()){
            
            
            trio itr=q.peek();
            q.remove();
            int step=itr.first;
            int node=itr.second;
            int dist=itr.third;
            
            
            
            for(Pair a:adj.get(node)){
                int adjnode=a.first;
                int adjdist=a.second;
                
                
                if(dist+adjdist<dis[adjnode]  && step<=k){
                    
                    
                    dis[adjnode]=dist+adjdist;
                    q.add(new trio(step+1,adjnode,dist+adjdist));
                }
            }
        }
        
        if(dis[dst]==(int)1e9)return -1;
        
        return dis[dst];
    }
}