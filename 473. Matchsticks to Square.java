class Solution {
    public boolean makesquare(int[] matchsticks) {
        int totalLength = 0;

        for (int s : matchsticks)
            totalLength += s;
        if (totalLength % 4 != 0)
            return false;
        Arrays.sort(matchsticks);
        int l = 0, r = matchsticks.length - 1;
        while (l < r) {
            matchsticks[l] = matchsticks[l] - matchsticks[r];
            matchsticks[r] += matchsticks[l];
            matchsticks[l] = matchsticks[r] - matchsticks[l];
            l++;
            r--;
        }
        return canBuildSquare(matchsticks, 1, totalLength / 4, new int[] { matchsticks[0], 0, 0, 0 });
    }

    private boolean canBuildSquare(int[] sticks, int index, int req, int[] length) {
        if (index >= sticks.length) {
            return length[0] == length[1] && length[0] == length[2]
                    && length[0] == length[3];
        }

        boolean doable = false;
        for (int i = 0; i < length.length; i++) {
            if (length[i] + sticks[index] <= req) {
                length[i] += sticks[index];
                doable |= canBuildSquare(sticks, index + 1, req, length);
                length[i] -= sticks[index];
            }
        }

        return doable;
    }
}