// 1888. Minimum Number of Flips to Make the Binary String Alternating

class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s += s;
        int mismatch1 = 0, mismatch2 = 0, res = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != (i % 2 == 0 ? '0' : '1'))
                mismatch1++;
            if (s.charAt(i) != (i % 2 == 0 ? '1' : '0'))
                mismatch2++;
            if (i >= n) {
                if (s.charAt(i - n) != ((i - n) % 2 == 0 ? '0' : '1'))
                    mismatch1--;
                if (s.charAt(i - n) != ((i - n) % 2 == 0 ? '1' : '0'))
                    mismatch2--;
            }
            if (i >= n - 1) {
                res = Math.min(res, Math.min(mismatch2, mismatch1));
                if (res == 0)
                    return 0;
            }
        }

        return res;

    }
}