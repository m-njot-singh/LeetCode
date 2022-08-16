import java.util.Map.Entry;
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(nums[i])){
                mp.put(nums[i],mp.get(nums[i])+1);
            }
            else{
                mp.put(nums[i],1);
            }
        }
        int max_count=0;
        int res=-1;
        for(Entry<Integer, Integer> val : mp.entrySet())
        {
            if (max_count < val.getValue())
            {
                res = val.getKey();
                max_count = val.getValue();
            }
        }
        
        return res;
    }
}