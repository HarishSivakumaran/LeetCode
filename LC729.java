// 729. My Calendar I
// // 

class MyCalendar {

    List<int[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList();
    }

    public boolean book(int start, int end) {
        int l = 0, r = calendar.size() - 1;
        int[] curr = new int[] { start, end };

        while (l <= r) {
            int m = l + (r - l) / 2;
            int[] mid = calendar.get(m);
            if (checkForMerge(curr, mid))
                return false;

            if (curr[0] >= mid[1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        if (l < calendar.size() && checkForMerge(curr, calendar.get(l)))
            return false;

        calendar.add(l, curr);
        return true;
    }

    public boolean checkForMerge(int[] curr, int[] mid) {
        return (curr[0] < mid[1]) && (curr[1] > mid[0]);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */