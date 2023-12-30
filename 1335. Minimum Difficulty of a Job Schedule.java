class Solution {
    Integer[][] cache = null;
    public int minDifficulty(int[] j, int d) {
        if(d > j.length)return -1;
        cache = new Integer[j.length][d+1];
        return getMin(j, 1, 0, d);
    }

    private int getMin(int[] j, int day, int from, int t) {
        if(from >= j.length) return 0;
        if(day > t) return 999999;
        if(cache[from][day] != null) return cache[from][day];
        int max = -1, min = Integer.MAX_VALUE;
        for(int i = from; i < j.length-(t-day); i++) {
            if(j[i] > max) max = j[i];
            min = Math.min(min, max + getMin(j, day+1, i+1, t));
        }

        return cache[from][day] = min;
    }
}