class Solution {
   
    public int uniquePaths(int n, int m) {
        int N=n+m-2;
        int r=n-1;
        long res=1;
        for(int i=1;i<=r;i++){
            res=res*(N-r+i)/i;
        }
        return (int)res;
    }
}