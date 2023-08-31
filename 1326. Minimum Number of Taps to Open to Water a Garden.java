class Solution {
    public int minTaps(int n, int[] ranges) {
        int start = 0, end = 0, count = 0;

        while(end < n) {
            for(int i = 0; i < ranges.length; i++) {
                if(i-ranges[i] <= start && i+ranges[i] >= end) {
                    end = Math.max(end,i+ranges[i]);
                }
            }
                if(start == end) return -1;
                start = end;
                count++;
        }
        return count;
    }
}x