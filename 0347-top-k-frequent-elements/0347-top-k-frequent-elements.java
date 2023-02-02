class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        System.out.println(map);
        
        PriorityQueue<Integer> p=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int n:map.keySet()){
            p.add(n);
        }
        
        for(int i=0;i<k;i++){
            ans[i]=p.peek();
            p.poll();
        }
        
        return ans;
    }
}