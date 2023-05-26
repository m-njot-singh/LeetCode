class Solution {
    public boolean canFinish(int V, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++){
            adj.get(pre[i][0]).add(pre[i][1]);
        }
        int count=0;
        int[] indegree=new int[V];
        for(int i=0;i<pre.length;i++){
            indegree[pre[i][1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            count++;
            for(int a:adj.get(node)){
                indegree[a]--;
                if(indegree[a]==0)q.add(a);
            }
        }
        if(count==V)return true;
        return false;
    }
}