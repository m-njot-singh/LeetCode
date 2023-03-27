class Solution {
    public int findCenter(int[][] edges) {
        int size=0;
        int q=0;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=edges.length+1;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        // System.out.println(adj);
        for(ArrayList<Integer> w:adj){
            if(w.size()==adj.size()-2){
                break;
            }
            q++;
        }
        return q;
    }
}