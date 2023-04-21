class Solution {
    HashMap<String, Integer> map = new HashMap();
    Integer[][][] memo = new Integer[101][101][101];

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        return getWays(n, minProfit, group, profit, 0);
    }

    public int getWays(int n, int minProfit, int[] group, int[] profit, int i) {

        if (i >= profit.length)
            return minProfit == 0 ? 1 : 0;

        if (memo[minProfit][i][n] != null)
            return memo[minProfit][i][n];

        int count = 0;
        count += getWays(n, minProfit, group, profit, i + 1);
        if (group[i] <= n) {
            count += getWays(n - group[i], Math.max(0, minProfit - profit[i]), group, profit, i + 1);
        }
        count %= 1000000007;

        return memo[minProfit][i][n] = count;

    }
}