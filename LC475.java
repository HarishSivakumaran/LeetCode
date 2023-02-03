// 475. Heaters

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int max = 0;

        for (int h : houses) {
            int l = 0, r = heaters.length - 1, ans = r;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (heaters[m] == h) {
                    ans = -1;
                    break;
                }

                if (h > heaters[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }

                if (ans == -1)
                    continue; // house on heater

                int d1 = l < heaters.length ? heaters[l] - h : Integer.MAX_VALUE;
                int d2 = l - 1 >= 0 ? h - heaters[l - 1] : Integer.MAX_VALUE;
                max = Math.max(max, Math.min(d1, d2));

            }
        }

        return max;

    }
}