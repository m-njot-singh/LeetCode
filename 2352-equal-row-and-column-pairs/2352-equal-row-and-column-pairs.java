class Solution {
    public int equalPairs(int[][] grid) {
        int count=0;
        HashMap<List<Integer>,Integer> map=new HashMap<>();
        for(int j=0;j<grid.length;j++){
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<grid[0].length;i++){
            l.add(grid[j][i]);
        }
            map.put(l,map.getOrDefault(l,0)+1);
        }
        
        for(int j=0;j<grid[0].length;j++){
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<grid.length;i++){
            l.add(grid[i][j]);
        }
            if(map.containsKey(l)){
                count+=map.get(l);
            }
        }
        return count;
    }
}