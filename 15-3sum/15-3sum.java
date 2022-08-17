class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> l= new LinkedList<>();
       
        for(int i=0;i<nums.length-2;i++){
           
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                 int lo=i+1; int hg=nums.length-1; int sum=0-nums[i];
                
                while(lo<hg){
                    if(nums[lo]+nums[hg]==sum){
                        l.add(Arrays.asList(nums[i],nums[lo],nums[hg]));
                        
                        while(lo<hg && nums[lo]==nums[lo+1])lo++;
                        while(lo<hg && nums[hg]==nums[hg-1])hg--;
                        
                        lo++;
                        hg--;
                    }
                    
                    else if(nums[lo]+nums[hg]<sum){
                        lo++;
                    }
                    else{
                        hg--;
                    }
                }
            }
        }
      return l;
    }
}