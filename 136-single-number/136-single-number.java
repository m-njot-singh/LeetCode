class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
       Arrays.sort(nums);
        int q=0;
        int w=0;
        for(int i=0;i<nums.length;i++){
            w=w+1;
            System.out.println(nums[q]);
            if(w==nums.length){
                return nums[q];
            }
            int a=nums[q];
            int b=nums[w];
            if(a==b){
                q=w+1;
                w=q;
            }
        }
        
        return nums[q];
        
    }
}