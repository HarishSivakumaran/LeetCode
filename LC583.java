// 583. Delete Operation for Two Strings

class Solution {
    int[][] dir = { { 1, 0 }, { 0, 1 } };// R D

    public int minDistance(String w1, String w2) {
        int i = 0, j = 0;
        Integer[][] dp = new Integer[w1.length() + 1][w2.length() + 1];
        return minOperations(w1, w2, 0, 0, dp);

    }

    public int minOperations(String w1, String w2, int i, int j, Integer[][] dp) {

        if (i == w1.length() && j == w2.length())
            return 0;

        if (i == w1.length())
            return w2.length() - j;

        if (j == w2.length())
            return w1.length() - i;

        if (dp[i][j] != null)
            return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;
        if (w1.charAt(i) == w2.charAt(j)) {
            return dp[i][j] = Math.min(dp[i][j], minOperations(w1, w2, i + 1, j + 1, dp));
        }

        for (int[] d : dir) {
            dp[i][j] = Math.min(dp[i][j], minOperations(w1, w2, i + d[0], j + d[1], dp));
        }

        dp[i][j]++;

        return dp[i][j];
    }
}