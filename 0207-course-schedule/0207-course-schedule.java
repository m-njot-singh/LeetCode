class Solution {
    public static boolean dfs(int node,int[] vis,ArrayList<ArrayList<Integer>> adj,int[] pathvis){
       vis[node]=1;
        pathvis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
                if(dfs(it,vis,adj,pathvis))return true; 
            }
            else{
                if(pathvis[it]==1)return true;
            }
        }
        pathvis[node]=0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] l) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:l){
            adj.get(it[0]).add(it[1]);
        }
        
       int[] vis=new int[numCourses];
        int[] pathvis=new int[numCourses];
        for(int i=0;i<numCourses;i++){
                if(dfs(i,vis,adj,pathvis))return false;
                
        }
        return true;
    }
}