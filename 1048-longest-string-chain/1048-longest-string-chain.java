class Solution {
    public static boolean check(String s1,String s2){
        if(s1.length()!=s2.length()+1)return false;
    
        int first = 0;
        int second = 0;

        while(first < s1.length()){
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                first ++;
                second ++;
            }
            else first ++;
        }
        if(first == s1.length() && second == s2.length()) return true;
        else return false; 
    }
    public int longestStrChain(String[] nums) {
         int n=nums.length;
        Arrays.sort(nums,Comparator.comparing(String::length));
       
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        int max=-1;
        int lastIndex=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(check(nums[i],nums[j]) && dp[j]+1>dp[i]){
                    dp[i]=1+dp[j];
                }
            }
            if(dp[i]>max){
                max=dp[i];
                lastIndex=i;
            }
        }
        
        return max;
    }
}