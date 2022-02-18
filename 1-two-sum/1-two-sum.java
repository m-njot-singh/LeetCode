class Solution {
    public int[] twoSum(int[] nums, int target) {
         int []num=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int a= target - nums[i];
                if(nums[j]==a){
                     num[0]=i;
                    num[1]=j;
                }
            }
        }
        return num;
    }
}