class Solution {
    public static void dfs(int node,int[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
                dfs(it,vis,adj);
            }
        }
    }
    public int findCircleNum(int[][] isconnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<isconnected.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<isconnected.length;i++){
            for(int j=0;j<isconnected[i].length;j++){
                if(isconnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count=0;
        int[] vis=new int[isconnected.length];
        for(int i=0;i<isconnected.length;i++){
            if(vis[i]==0){
                count++;
                dfs(i,vis,adj);
            }
        }
        return count;
    }
}