class Solution {
    Integer[] cache = null;
    Integer maxLen = 0;

    public int numberOfArrays(String s, int k) {
        cache = new Integer[s.length()];
        String val = Integer.toString(k);
        maxLen = Math.min(10, val.length() + 1);
        return findWays(0, s, k);
    }

    public int findWays(int index, String s, int k) {
        if (index >= s.length())
            return 1;
        if (s.charAt(index) == '0')
            return 0;
        if (cache[index] != null)
            return cache[index];
        long count = 0;
        for (int i = index + 1; i <= s.length() && (i - index + 1 <= maxLen); i++) {
            if (Integer.parseInt(s.substring(index, Math.min(s.length(), i))) <= k)
                count += (findWays(i, s, k));
        }

        count %= 1000000007;

        return cache[index] = (int) count;
    }

}