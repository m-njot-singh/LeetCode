class Solution {
    public static int power(long x, long y)
    {
        long temp;
        if (y == 0)
            return 1;
        temp = power(x, y / 2);
 
        if (y % 2 == 0)
            return (int)((temp * temp)%(int)(1e9+7));
        else {
            if (y > 0)
                return (int) ((x * temp * temp)%(int)(1e9+7));
            else
                return(int) (((temp * temp) / x)%(int)(1e9+7));
        }
    }
    public int numSubseq(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        Arrays.sort(nums);
        int count=0;
        while(i<=j){
            if(nums[i]+nums[j]<=target){
                count+=power(2,j-i);
                count=count%(int)(1e9+7);
                i++;
            }
            else{
               j--; 
            }
        }
        return count;
        
    }
}