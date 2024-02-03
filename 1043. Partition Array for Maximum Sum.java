class Solution {
    Integer[][] cache;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        cache = new Integer[arr.length][arr.length];
        return getMax(arr, 0, 0, -1, k);
    }

    private int getMax(int[] arr, int currIndex, int lastCut, int maxTill, int k) {
        if(currIndex >= arr.length) return 0;
        if(cache[currIndex][lastCut] != null) return cache[currIndex][lastCut];

        // try cutting
        int len = currIndex-lastCut+1, ans = 0;
        int max = Math.max(maxTill, arr[currIndex]);
        if(len > k) return 0;
        if(len > 0) {
            ans = max*len + getMax(arr, currIndex+1, currIndex+1, -1, k);
        }

        ans = Math.max(ans, getMax(arr, currIndex+1, lastCut, max, k));

        return cache[currIndex][lastCut] = ans;

    }
}