class Solution {
    public int subarraySum(int[] nums, int k) {
        int i=0,j=0;
        int sum=0;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        while(j<nums.length){
            sum+=nums[j];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k); 
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            
            j++;
            
        }
        
        return count;
    }
}