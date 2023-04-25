class SmallestInfiniteSet {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    HashSet<Integer> set = new HashSet();
    int curr = 1;

    public SmallestInfiniteSet() {

    }

    public int popSmallest() {
        if (pq.size() > 0) {
            int curr = pq.poll();
            set.remove(curr);
            return curr;
        }

        return curr++;
    }

    public void addBack(int num) {
        if (num >= curr)
            return;
        if (!set.contains(num)) {
            pq.add(num);
            set.add(num);
        }

    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */