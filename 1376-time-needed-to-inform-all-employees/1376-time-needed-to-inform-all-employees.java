class Solution {
    public static int max=0;
    public static int sum=0;
    public static void dfs(Map<Integer,ArrayList<Integer>> map,int [] time,int manager){
        if(!map.containsKey(manager)){
            max=Math.max(max,sum);
            return;
        }
        for(int employe:map.get(manager)){
            sum+=time[manager];
            dfs(map,time,employe);
            sum-=time[manager];
        }
        

    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
       
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(manager[i]==-1)continue;
            if(!map.containsKey(manager[i])){
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(i);
                map.put(manager[i],new ArrayList<>(temp));
            }
            else{
                ArrayList<Integer> temp=map.get(manager[i]);
                temp.add(i);
                map.put(manager[i],new ArrayList<>(temp));
            }
        }
        
        sum=0;
        max=0;
        dfs(map,informTime,headID);
        return max;
        
    }
}