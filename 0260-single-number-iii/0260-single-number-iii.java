class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int j=0;
        for(Map.Entry<Integer,Integer> i:map.entrySet()){
            if(i.getValue()==1)ans[j++]=i.getKey();
        }
        return ans;
    }
}