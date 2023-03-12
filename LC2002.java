// 2002. Maximum Product of the Length of Two Palindromic Subsequences

class Solution {
    int max = 1;

    public int maxProduct(String s) {
        char[] c = s.toCharArray();
        dfs(c, 0, "", "");
        return max;
    }

    public void dfs(char[] c, int i, String s1, String s2) {
        if (isPalin(s1) && isPalin(s2)) {
            max = Math.max(s1.length() * s2.length(), max);
        }
        if (i >= c.length)
            return;

        dfs(c, i + 1, s1 + c[i], s2);
        dfs(c, i + 1, s1, s2 + c[i]);
        dfs(c, i + 1, s1, s2);
    }

    public boolean isPalin(String s) {
        int l = 0, r = s.length() - 1;

        while (l <= r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }

        return l > r;
    }

}