class Solution {
    int[] prefSum = null;
    Integer[][] cache = null;
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0, m = 0;
        for(int n : nums) {
            l = Math.max(l, n);
            r += n;
        }

        while(l <= r) {
            m = l+(r-l)/2;

            if(isDoable(nums, k, m)) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return l;
    }
    private boolean isDoable(int[] nums, int divs, int maxSumCap) {
        int curr = 0, div = 1;
        for(int n : nums){
            if(curr + n > maxSumCap) {
                curr = 0;
                div++;
            }
            curr += n;
            if(div > divs) return false;
        }
        return div <= divs;
    }

    // private int getMinSum(int[] nums, int k, int i) {
    //     if(k == 1) {
    //         return prefSum[nums.length-1]-(i-1 >= 0 ?prefSum[i-1] : 0);
    //     } 
    //     if(i >= nums.length || k < 1) return Integer.MAX_VALUE;
    //     if(cache[i][k] != null) return cache[i][k];

    //     int ans = Integer.MAX_VALUE;

    //     for(int to = i; to < nums.length-(k-1); to++) {
    //         ans = Math.min(ans, Math.max(
    //             prefSum[to]-(i-1 >= 0 ? prefSum[i-1].  : 0),
    //             getMinSum(nums, k-1, to+1)
    //         ));
    //     }

    //     return cache[i][k] = ans;
    // }
}