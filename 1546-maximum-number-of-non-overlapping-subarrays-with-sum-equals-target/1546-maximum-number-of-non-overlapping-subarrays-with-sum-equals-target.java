class Solution {
    public int maxNonOverlapping(int[] nums, int k) {
        int j=0;
        int sum=0;
        int count=0;
        // if(k==0)return nums.length;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,-1);
        int lastIndex=-1;
        while(j<nums.length){
            sum+=nums[j];
            if(map.containsKey(sum-k) && map.get(sum-k)>=lastIndex){
                count++;
                lastIndex=j;
            }
            map.put(sum,j);
            j++;
            
        }
        return count;
    }
}