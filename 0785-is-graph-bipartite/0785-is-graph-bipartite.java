class Solution {
    public static boolean isBipartite(int node,int[] col,int[][] graph){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        col[node]=1;
        while(!q.isEmpty()){
            int adjnode=q.poll();
            for(Integer it:graph[adjnode]){
                if(col[it]==-1){
                    q.add(it);
                    col[it]=1-col[adjnode];
                }
                else if(col[it]==col[adjnode])return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int col[]=new int[graph.length];
        Arrays.fill(col,-1);
        
        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){
                if(isBipartite(i,col,graph)==false)return false;
            }
            
        }
        return true;
    }
}