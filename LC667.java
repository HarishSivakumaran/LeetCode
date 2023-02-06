// 667. Beautiful Arrangement II
// 667. Beautiful Arrangement II

class Solution {
    public int[] constructArray(int n, int k) {
        int[] arr = new int[n];
        int i = 0;
        for (int j = 1; j < n - k; j++) {
            arr[i++] = j;
        }

        for (int j = 0; j <= k; j++) {
            arr[i++] = (j % 2 == 0) ? n - k + (j / 2) : (n - (j / 2));
        }

        return arr;

    }
}