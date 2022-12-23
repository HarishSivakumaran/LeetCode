class Solution {

    public static void main(String[] args) {
       int a = Solution.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0);
       System.out.println(a);
    }

    public static int search(int[] n, int t) {
        int l = 0, r = n.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (t == n[m]) {
                return m;
            }

            if (n[m] >= n[l]) { // left sorted portion
                if (t > n[m] || (t < n[m] && t < n[l])) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }

            } else { // right sorted portion
                if (t < n[m] || (t > n[m] && t > n[r])) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }

            }
        }

        return -1;

    }
}