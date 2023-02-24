// 1675. Minimize Deviation in Array

class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        int min = Integer.MAX_VALUE, diff = Integer.MAX_VALUE, j = 0;
        for (int i : nums) {
            if (i % 2 == 1)
                i *= 2;
            pq.add(i);
            min = Math.min(min, i);
        }

        while (pq.peek() % 2 == 0) {
            j = pq.poll();
            diff = Math.min(diff, j - min);
            min = Math.min(j / 2, min);
            pq.add(j / 2);
        }

        return Math.min(diff, pq.peek() - min);
    }
}