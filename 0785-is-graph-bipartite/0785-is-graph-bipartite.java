class Solution {
    public static boolean dfs(int node,int[] vis,int [][] graph){
        if(vis[node]==-1){
            vis[node]=0;
        }
        
        for(int a:graph[node]){
            if(vis[a]==-1){
                vis[a]=1-vis[node];
                if(dfs(a,vis,graph)==false)return false;
            }
            else if(vis[a]==vis[node])return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int m=graph[0].length;
        int [] vis=new int[graph.length];
        for(int i=0;i<n;i++){
            vis[i]=-1;
        }
        for(int i=0;i<n;i++){
            if(vis[i]==-1){
                if(dfs(i,vis,graph)==false)return false;
            }
        }
        return true;
    }
}