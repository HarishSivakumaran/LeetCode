class Solution {
    int mod = 1000000007;
    Integer[][] cache = null;
    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps);
        cache = new Integer[arrLen][steps+1];
        return getWays(steps, arrLen, 0);
    }

    private int getWays(int steps, int arrLen, int index) {
        if(steps == 0) {
            return index == 0 ? 1 : 0;
        }

        if(cache[index][steps] != null) return cache[index][steps];

        int ways = 0;

        // stay
        if(steps > index) {
            ways += getWays(steps-1, arrLen, index);
        }

        ways %= mod;

        // right
        if(steps-1 >= index+1 && index < arrLen-1) {
            ways += getWays(steps-1, arrLen, index+1);
        }
        ways %= mod;


        // left
        if(index-1 >= 0) ways += getWays(steps-1, arrLen, index-1);
        ways %= mod;

        return cache[index][steps] = ways;
    }
}