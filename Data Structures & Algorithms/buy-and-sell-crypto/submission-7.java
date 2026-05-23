class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int bestBuy = prices[0];

        for(int sell : prices){
            maxProfit = Math.max(maxProfit, sell - bestBuy);
            bestBuy = Math.min(bestBuy, sell);
        }
        return maxProfit;
    }
}
