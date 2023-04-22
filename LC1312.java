// 1312. Minimum Insertion Steps to Make a String Palindrome

class Solution {
    Integer[][] cache = null;

    public int minInsertions(String s) {
        cache = new Integer[s.length() + 1][s.length() + 1];
        return getMinInsertion(s, 0, s.length() - 1);
    }

    public int getMinInsertion(String s, int l, int r) {

        if (l >= r)
            return 0;

        if (cache[l][r] != null)
            return cache[l][r];

        int count = 0;

        if (s.charAt(l) == s.charAt(r)) {
            count = getMinInsertion(s, l + 1, r - 1);
        } else {
            count = 1 + Math.min(getMinInsertion(s, l + 1, r), getMinInsertion(s, l, r - 1));
        }

        return cache[l][r] = count;

    }
}