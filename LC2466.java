// 2466. Count Ways To Build Good Strings

class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] count = new long[high + 1];
        long mod = 1000000007;
        count[0] = 1;
        long res = 0;

        for (int i = 1; i < count.length; i++) {
            if (i >= one) {
                count[i] += count[i - one];
            }

            if (i >= zero) {
                count[i] += count[i - zero];
            }

            count[i] %= mod;

            if (i >= low) {
                res += count[i];
                res %= mod;
            }
        }

        for (long i : count)
            System.out.println(i);

        return (int) res;
    }
}