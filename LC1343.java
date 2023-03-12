// 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l = 0, r = 0, count = 0;
        long sum = 0;

        while (r < arr.length && r < k) {
            sum += arr[r++];
        }
        if (sum / k >= threshold)
            count++;
        r--;

        while (r < arr.length - 1) {
            sum -= arr[l++];
            sum += arr[++r];
            if (sum / k >= threshold)
                count++;
        }

        return count;

    }
}