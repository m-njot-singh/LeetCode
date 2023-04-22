class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int a: nums){
            map.put(a,map.getOrDefault(a,0)+1);
            if(map.get(a)>1){
                return true;
            }
        }
        return false;
    }
}