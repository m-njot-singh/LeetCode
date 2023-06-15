class Solution {
    public int maxProfit(int[] prices) {
       int diff=prices[0];
        int maxprofit=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
                maxprofit=Math.max(prices[i]-diff,maxprofit);
                diff=Math.min(diff,prices[i]);
        }
        return maxprofit;
    }
}