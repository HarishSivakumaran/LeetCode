class SummaryRanges {
    List<int[]> intervals = new ArrayList();

    public SummaryRanges() {
        
    }
    
    public void addNum(int value) {
        List<int[]> temp = new ArrayList();
        int[] insert = {value, value};
        for(int i = 0; i < intervals.size(); i++) {
            int[] curr = intervals.get(i);
            // curr before insert
            if(insert == null || curr[1] < insert[0]-1) {
                temp.add(curr);
                continue;
            }

            // merge case
            if(curr[1] >= insert[0]-1 && curr[0] <= insert[1]+1) {
                insert[0] = Math.min(insert[0], curr[0]);
                insert[1] = Math.max(insert[1], curr[1]);
                continue;
            }

            // insert before curr
            temp.add(insert);
            temp.add(curr);
            insert= null;
        }
        if(insert != null) temp.add(insert);
        intervals = temp;
        
    }
    
    public int[][] getIntervals() {
        int[][] out = new int[intervals.size()][2];
        return intervals.toArray(out);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */