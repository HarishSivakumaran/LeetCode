class SeatManager {
    int nextAvail = 1;
    TreeSet<Integer> unreservedSeats = new TreeSet();

    public SeatManager(int n) {
        
    }
    
    public int reserve() {
        int seat = -1;
        if(unreservedSeats.size() > 0) {
            seat = unreservedSeats.pollFirst();
        } else {
            seat = nextAvail++;
        }
        return seat;
    }
    
    public void unreserve(int seatNumber) {
        unreservedSeats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */