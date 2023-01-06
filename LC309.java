// 309. Best Time to Buy and Sell Stock with Cooldown

class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String, Integer> cache = new HashMap<>(); 
        return dfs(prices, cache, 0, true);    
    }

    public int dfs(int[] prices, HashMap<String, Integer> cache, int index, boolean buying){
        if(index >= prices.length) return 0;

        String key = index + "-" + buying;

        if(cache.containsKey(key)) return cache.get(key);

        int cooldown = dfs(prices, cache, index+1, buying);

        int bOrS = 0;

        if(buying){
            bOrS = dfs(prices, cache, index+1, !buying) - prices[index];
        }else{
            bOrS = dfs(prices, cache, index+2, !buying) + prices[index];
        }

        cache.put(key, Math.max(cooldown, bOrS));

        return cache.get(key);

    }
}