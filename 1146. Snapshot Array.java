class SnapshotArray {
    //index, snap, val
    HashMap<Integer, TreeMap<Integer, Integer>> snap = new HashMap();
    int snapPtr = 0;

    public SnapshotArray(int length) {
        snap = new HashMap();
    }
    
    public void set(int index, int val) {
        snap.computeIfAbsent(index, v -> new TreeMap())
        .put(snapPtr, val);
    }
    
    public int snap() {
        return snapPtr++;
    }
    
    public int get(int index, int snap_id) {
        if(snap.get(index) == null) return 0;
        if(snap.get(index).containsKey(snap_id)) return snap.get(index).get(snap_id);

        // find the next smaller snap_id, if not found return 0
        List<Integer> snapList = snap.get(index)
        .keySet()
        .stream()
        .map(obj -> Integer.valueOf(obj))
        .toList();
        int l = 0, r = snapList.size()-1;

        while(l <= r){
            int m = l + (r-l)/2;
            if(snapList.get(m) > snap_id){
                r = m-1;
            }else{
                l = m+1;
            }
        }

        return r < 0 ? 0 : snap.get(index).get(snapList.get(r));
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */