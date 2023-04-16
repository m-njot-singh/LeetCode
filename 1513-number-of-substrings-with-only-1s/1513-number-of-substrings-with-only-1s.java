class Solution {
    public int numSub(String nums) {
        long j=0;
        long ans=0;
        long mode=(int)1e9+7;
        for(int i=0;i<nums.length();i++){
            if(nums.charAt(i)!='1')j=i+1;
            else if(nums.charAt(i)!='1'){
                j++;
            }
            else if(nums.charAt(i)=='1'){
                ans+=i-j+1;
            }
        }
        
        return (int)(ans%mode);
    }
}