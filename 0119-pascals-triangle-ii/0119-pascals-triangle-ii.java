class Solution {
    
    
    public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for(int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public List<Integer> getRow(int n) {
        List<Integer> ans=new ArrayList<>();
        for (int c =0; c <=n; c++) {
            ans.add((int)nCr(n, c));
        }
        
        return ans;
    }
}