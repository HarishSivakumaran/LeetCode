// 1921. Eliminate Maximum Number of Monsters

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int res = 0;

        for (int i = 0; i < dist.length; i++) {
            pq.add((int) Math.ceil((double) dist[i] / speed[i]));
        }

        int t = 0;

        while (pq.size() > 0) {
            if (pq.peek() - t <= 0)
                return res;
            pq.poll();
            res++;
            t++;
        }

        return res;
    }
}