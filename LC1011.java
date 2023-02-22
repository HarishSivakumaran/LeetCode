// 1011. Capacity To Ship Packages Within D Days

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, min = -1, m = 0;
        for (int w : weights) {
            max += w;
            min = Math.max(min, w);
        }
        if (days == 1)
            return max;

        while (min <= max) {
            m = min + (max - min) / 2;
            if (checkIfPossible(weights, m, days)) {
                max = m - 1;
            } else {
                min = m + 1;
            }
        }

        return min;

    }

    public boolean checkIfPossible(int[] w, int posW, int days) {
        int sum = 0, daysAns = 1;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            if (sum > posW) {
                daysAns++;
                sum = w[i];
            }
            if (daysAns > days)
                return false;
        }

        return true;

    }
}