// 1985. Find the Kth Largest Integer in the Array

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<String>((a, b) -> {
            if (a.length() != b.length())
                return a.length() - b.length();
            return a.compareTo(b);
        });

        for (String n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}