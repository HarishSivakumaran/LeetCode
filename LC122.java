// 122. Best Time to Buy and Sell Stock II

// class Solution {
//     public int maxProfit(int[] prices) {
// 		// We need prices for 2 days at least to find the profit.
//         if (prices == null || prices.length <= 1) {
//             return 0;
//         }

//         int totalProfit = 0;
//         for (int i = 1; i < prices.length; i++) {
//             // Checking if we can profit with previous day's price.
//             // If yes, then we buy on previous day and sell on current day.
//             // Add all such profits to get the total profit.
//             if (prices[i - 1] < prices[i]) {
//                 totalProfit += prices[i] - prices[i - 1];
//             }
//         }

//         return totalProfit;
//     }
// }

class Solution {
    public int maxProfit(int[] prices) {
        return max(prices, 0, true, new HashMap());
    }

    public int max(int[] p, int i, boolean buy, HashMap<String, Integer> cache) {
        if (i >= p.length)
            return 0;

        String key = (buy ? "B" : "S") + "-" + i;
        if (cache.containsKey(key))
            return cache.get(key);

        int maxProfit = 0, hold = 0;

        // hold
        hold = Math.max(maxProfit, max(p, i + 1, buy, cache));

        if (buy) {
            // buy
            maxProfit = Math.max(maxProfit, max(p, i + 1, !buy, cache)) - p[i];
        } else {
            // sell
            maxProfit = Math.max(maxProfit, max(p, i + 1, !buy, cache)) + p[i];
        }

        cache.put(key, Math.max(hold, maxProfit));

        return cache.get(key);

    }
}