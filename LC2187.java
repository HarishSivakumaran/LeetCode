// 2187. Minimum Time to Complete Trips
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        if (time.length == 1)
            return (long) time[0] * (long) totalTrips;

        Arrays.sort(time);
        long r = (long) time[0] * (long) totalTrips, l = 1, m = 0;

        while (l <= r) {
            m = l + (r - l) / 2;
            if (check(time, m, totalTrips)) {
                r = m - 1;
            } else {
                l = m + 1;
            }

        }

        return l;

    }

    public boolean check(int[] time, long m, int totalTrips) {
        long tot = 0;
        for (int t : time) {
            tot += (m / t);
            if (tot >= totalTrips)
                return true;
        }
        return false;
    }
}