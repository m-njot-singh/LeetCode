class Solution {
    public static boolean dfs(int node,boolean[] check,int[][] adj,boolean[] vis,boolean[] pathvis){
        vis[node]=true;
        pathvis[node]=true;
        for(int it:adj[node]){
            if(vis[it]==false){
                if(dfs(it,check,adj,vis,pathvis)==true){
                    return true;
                }
            }
            else if(pathvis[it]==true){
                return true;
            }
        }
        check[node]=true;
        pathvis[node]=false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] adj) {
        int size=adj.length;
        List<Integer> ans=new ArrayList<>();
        boolean[] vis=new boolean[size];
        boolean[] pathvis=new boolean[size];
        boolean[] check=new boolean[size];
        for(int i=0;i<size;i++){
            if(vis[i]==false){
                dfs(i,check,adj,vis,pathvis);
            }
        }
        
        for(int i=0;i<size;i++){
            if(check[i]==true){
                ans.add(i);
            }
        }
        return ans;
    }
}