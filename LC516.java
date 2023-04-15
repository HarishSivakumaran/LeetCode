// 516. Longest Palindromic Subsequence

class Solution {
    public int longestPalindromeSubseq(String s) {
        Integer[][] cache = new Integer[s.length()][s.length()];

        return findLPSPalind(s, 0, s.length() - 1, cache);
    }

    public int findLPSPalind(String str, int i, int j, Integer[][] cache) {
        if (i > j)
            return 0;

        if (i == j)
            return 1;

        if (cache[i][j] != null)
            return cache[i][j];

        int val = 0;

        if (str.charAt(i) == str.charAt(j)) {
            val = 2 + findLPSPalind(str, i + 1, j - 1, cache);
        } else {
            val = Math.max(findLPSPalind(str, i + 1, j, cache), findLPSPalind(str, i, j - 1, cache));
        }

        cache[i][j] = val;

        return val;

    }

    public boolean isPalin(StringBuilder str) {
        int l = 0, r = str.length() - 1;
        while (l <= r && str.charAt(l) == str.charAt(r)) {
            l++;
            r--;
        }

        return l > r;
    }
}