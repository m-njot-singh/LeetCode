class Pair{
    int nums;
    int cost;
    Pair(int _nums,int _cost){
        this.nums=_nums;
        this.cost=_cost;
    }
}
class Solution {
    public long minCost(int[] nums, int[] cost) {
        ArrayList<Pair> temp = new ArrayList<Pair>();
        for(int i=0;i<nums.length;i++){
            temp.add(new Pair(nums[i],cost[i]));
        }
        Collections.sort(temp,(a,b)-> a.nums-b.nums);
        long median=0;
        
        for(int i=0;i<temp.size();i++){
            median+=temp.get(i).cost;
        }
        median=(median+1)/2;
        long mednum=0;
        long currsum=0;
        for(int i=0;i<nums.length && currsum<median ;i++){
            currsum+=temp.get(i).cost;
            mednum=temp.get(i).nums;
        }
        
        long count=0;
        for(int i=0;i<nums.length;i++){
            count+= (Math.abs(nums[i]-mednum))*cost[i];
        }
        return count;
    }
}