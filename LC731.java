// 731. My Calendar II

class MyCalendarTwo {
    // class Event{
    // public int start = 0, end = 0;
    // public boolean isDoubleBooked = false;
    // Event(int start, int end){
    // this.start = start;
    // this.end = end;
    // }
    // }

    // List<Event> list;
    // List<Event> overlaps;
    TreeMap<Integer, Integer> timeline;

    public MyCalendarTwo() {
        timeline = new TreeMap();

    }

    public boolean book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);
        int active = 0;
        for (int v : timeline.values()) {
            active += v;
            if (active >= 3) {
                timeline.put(start, timeline.getOrDefault(start, 0) - 1);
                timeline.put(end, timeline.getOrDefault(end, 0) + 1);
                return false;
            }
        }

        return true;

        // int l = 0, r = list.size()-1;
        // Event curr = new Event(start, end);

        // while(l <= r){
        // int mid = l + (r-l)/2;
        // Event m = list.get(mid);
        // if(checkIfMerge(curr, m)){
        // for(Event eve : overlaps){
        // if(checkIfMerge(curr, eve)) return false;
        // }
        // Event doubleBookedEvent = new Event(Math.max(curr.start, m.start),
        // Math.min(curr.end, m.end));
        // overlaps.add(doubleBookedEvent);
        // return true;
        // }

        // if(curr.start >= m.end){
        // l = mid+1;
        // }else{
        // r = mid-1;
        // }
        // }

        // list.add(l, curr);
        // return true;

    }

    // public boolean checkIfMerge(Event curr, Event mid){
    // return (curr.start < mid.end) && (curr.end > mid.start);
    // }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */