// 56. Merge Intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> out = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prevInt = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            // prev is before curr
            if (prevInt[1] < intervals[i][0]) {
                out.add(prevInt);
                prevInt = intervals[i];
                continue;
            }

            // merge
            if (prevInt[0] <= intervals[i][1] && prevInt[1] >= intervals[i][0]) {
                prevInt[0] = Math.min(intervals[i][0], prevInt[0]);
                prevInt[1] = Math.max(intervals[i][1], prevInt[1]);
                continue;
            }

        }
        if (prevInt != null)
            out.add(prevInt);

        return out.toArray(new int[out.size()][2]);

    }
}