class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> out = new ArrayList();

        for (int[] interval : intervals) {
            // if new interval is before the current one
            if (newInterval != null && newInterval[1] < interval[0]) {
                out.add(newInterval);
                newInterval = null;
            }
            // check for Merge
            else if (newInterval != null && newInterval[0] <= interval[1] && newInterval[1] >= interval[0]) {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
                continue;
            }

            // add the current one
            out.add(interval);

        }

        if (newInterval != null)
            out.add(newInterval);

        return out.toArray(new int[out.size()][2]);
    }
}