class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList();
        for (int[] curr : intervals) {
            if (newInterval == null || curr[1] < newInterval[0]) {
                list.add(curr);
            } else if (newInterval[0] <= curr[1] && newInterval[1] >= curr[0]) {
                // merge
                newInterval[0] = Math.min(curr[0], newInterval[0]);
                newInterval[1] = Math.max(curr[1], newInterval[1]);
            } else if (newInterval[1] < curr[0]) {
                list.add(newInterval);
                list.add(curr);
                newInterval = null;
            }
        }

        if(newInterval != null) list.add(newInterval);

        int[][] out = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) out[i] = list.get(i);

        return out;
    }
}