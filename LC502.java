// 502. IPO

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] list = new int[profits.length][2];
        int i = 0;
        for (; i < profits.length; i++) {
            list[i][0] = capital[i];
            list[i][1] = profits[i];
        }

        Arrays.sort(list, (a, b) -> {
            return a[0] - b[0];
        });

        int ptr = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);

        for (i = 0; i < k; i++) {
            while (ptr < list.length && list[ptr][0] <= w) {
                pq.add(list[ptr++]);
            }

            if (pq.size() == 0)
                return w;

            w += pq.poll()[1];

        }

        return w;

    }
}