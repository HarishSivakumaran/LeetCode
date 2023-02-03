// 474. Ones and Zeroes

class Solution {

    int ans = 0;

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] list = new int[strs.length][2];
        int toones = 0, totz = 0, j = 0;

        for (String s : strs) {
            int ones = 0, zeroes = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) - '0' == 0) {
                    zeroes++;
                } else {
                    ones++;
                }
            }
            toones += ones;
            totz += zeroes;

            list[j++] = new int[] { zeroes, ones };
        }

        if (totz <= m && toones <= n)
            return strs.length;

        return getMaxLen(list, new int[] { 0, 0 }, new int[] { m, n }, 0, new Integer[m + 1][n + 1][strs.length]);

    }

    public int getMaxLen(int[][] list, int[] curr, int[] max, int i, Integer[][][] dp) {

        if (curr[0] > max[0] || curr[1] > max[1])
            return 0;

        if (i >= list.length)
            return 0;

        if (dp[curr[0]][curr[1]][i] != null)
            return dp[curr[0]][curr[1]][i];

        int[] curData = list[i];

        curr[0] += curData[0];
        curr[1] += curData[1];
        int a = getMaxLen(list, curr, max, i + 1, dp);
        if (curr[0] <= max[0] && curr[1] <= max[1])
            a++;
        curr[0] -= curData[0];
        curr[1] -= curData[1];
        int b = getMaxLen(list, curr, max, i + 1, dp);

        dp[curr[0]][curr[1]][i] = Math.max(a, b);

        return dp[curr[0]][curr[1]][i];

    }

}