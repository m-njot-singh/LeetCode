class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer> l=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        for(int a: map.keySet()){
            if(map.get(a)>(n/3)){
                l.add(a);
            }
        }
        return l;
    }
}