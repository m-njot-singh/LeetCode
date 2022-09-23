class Solution {
    public int concatenatedBinary(int n) {
        long ans=0;
        int mod=1000000007;
        for(int i=0;i<=n;i++){
            String s=Integer.toBinaryString(i);
            int length=s.length();
            ans=(ans<<length)%mod;
            ans=(ans+i)%mod;
        }
        
        return (int)ans;
    }
}