class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans=new int[k];
        HashMap<Integer,Set<Integer>> map=new HashMap<>();
        for(int [] a:logs){
            map.putIfAbsent(a[0],new HashSet<>());
            map.get(a[0]).add(a[1]);
        }
        // System.out.println(map);
        int count=0;
        for(Set<Integer> m: map.values()){
            int size=m.size()-1;
            ans[size]++;
        }
        return ans;
    }
}