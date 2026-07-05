class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        
        // Start from the second day and check consecutive pairs
        for (int i = 1; i < prices.length; i++) {
            // If today's price is higher than yesterday's, take the profit
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }
        
        return totalProfit;
    }
}
