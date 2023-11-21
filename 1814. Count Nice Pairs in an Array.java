class Solution {
    public int countNicePairs(int[] nums) {
        int mod = 1000000007;
        long ans = 0;
        HashMap<Integer, Integer> count = new HashMap();

        for(int n : nums) {
            int rev = getReverse(n);
            ans += count.getOrDefault(n-rev, 0);
            ans %= mod;
            count.put(n-rev, count.getOrDefault(n-rev, 0)+1);
        }

        return (int)ans;
    }

    private int getReverse(int n) {
        int ans = 0;
        while(n > 0) {
            ans = (ans*10) + (n%10);
            n /= 10;
        }

        return ans;
    }
}