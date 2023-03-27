class Solution {
     public void bfs(int V,int[] vis ,ArrayList<ArrayList<Integer>> adj) {
        
        // ArrayList < Integer > bfs = new ArrayList < > ();
        Queue < Integer > q = new LinkedList < > ();

        q.add(V);
        vis[V] = 1;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            // bfs.add(node);
            for (Integer it: adj.get(node)) {
                if (vis[it] == 0) {
                    vis[it] = 1;
                    q.add(it);
                }
            }
        }

        return ;
    } 
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        int ans=0;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<connections.length;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        // System.out.println(adj);
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            vis[i]=0;
        }
        
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                bfs(i,vis,adj);
                ans++;
            }
        }
        
        return ans-1;
    }
}





// class Solution {
//     public int makeConnected(int n, int[][] connections) {
//         if(connections.length<n-1) return -1;
//         //create undirected network
//         HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//         for(int[] i:connections){
//             ArrayList<Integer> a = map.getOrDefault(i[0], new ArrayList<>());
//             a.add(i[1]);
//             map.put(i[0], a);
//             a = map.getOrDefault(i[1], new ArrayList<>());
//             a.add(i[0]);
//             map.put(i[1], a);
//         }
//         // count the number of components c
//         int c=0;
//         HashSet<Integer> vis = new HashSet<>();
//         for(int i=0;i<n;i++){
//             if(!vis.contains(i)){
//                 dfs(i, map, vis);
//                 c++;
//             }
//         }
//         return c-1;
//     }
//     public void dfs(int curr, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> visited){
//         if(visited.contains(curr)) return;
//         visited.add(curr);
//         for(int nei: map.getOrDefault(curr, new ArrayList<>())){
//             dfs(nei, map, visited);
//         }
//     }
// }