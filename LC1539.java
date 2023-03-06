// 1539. Kth Missing Positive Number

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int prev = 0;
        for (int i : arr) {
            if (k - (i - prev - 1) > 0) {
                k -= (i - prev - 1);
                prev = i;
            } else {
                return prev + k;
            }
        }

        return prev + k;
    }
}