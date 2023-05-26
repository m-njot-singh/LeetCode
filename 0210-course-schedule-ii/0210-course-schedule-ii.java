class Solution {
    public int[] findOrder(int V, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++){
            adj.get(pre[i][1]).add(pre[i][0]);
        }
        int count=0;
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int a:adj.get(i)){
                indegree[a]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] ans=new int[V];
        // int i=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            l.add(node);
            for(int a:adj.get(node)){
                indegree[a]--;
                if(indegree[a]==0)q.add(a);
            }
        }
        if(l.size()==V){
            for(int i=0;i<V;i++){
                ans[i]=l.get(i);
            }
            return ans;
        }
        int[] na=new int[0];
        return na;
    }
}