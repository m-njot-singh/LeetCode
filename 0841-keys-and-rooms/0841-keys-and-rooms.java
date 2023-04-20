class Solution {
    public static void dfs(int node,List<List<Integer>> rooms,int[] vis){
        vis[node]=1;
        for(int a:rooms.get(node)){
            if(vis[a]==0){
                dfs(a,rooms,vis);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
       
        int[] vis=new int[rooms.size()];
         // System.out.println(vis.length);
        dfs(0,rooms,vis);
        for(int i=0;i<vis.length;i++){
            // System.out.println(vis[i]);
            if(vis[i]==0)return false;
        }
        return true;
    }
}