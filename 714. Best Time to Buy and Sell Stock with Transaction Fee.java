class Solution {
    Integer[][] cache = null;
    public int maxProfit(int[] prices, int fee) {
        cache = new Integer[prices.length+1][2];
        return getMaxProfit(prices, fee, 0, true);
    }

    public int getMaxProfit(int[] prices, int fee, int index, boolean isBuying){
        if(index >= prices.length) return 0;

        if(cache[index][isBuying ? 1 : 0] != null) return cache[index][isBuying ? 1 : 0];
        int ans = 0;
        if(isBuying){
            ans = Math.max(getMaxProfit(prices, fee, index+1, isBuying), 
                getMaxProfit(prices, fee, index+1, !isBuying) - prices[index] - fee
            );
        } else {
            ans = Math.max(getMaxProfit(prices, fee, index+1, isBuying),
                (prices[index]) + getMaxProfit(prices, fee, index+1, !isBuying)
            );
        }

        return cache[index][isBuying ? 1 : 0] = ans;
    }
}