// 1834. Single-Threaded CPU
// // 
class Solution {
    public int[] getOrder(int[][] tasks) {
        HashMap<int[], Integer> orderMap = new HashMap();
        for (int j = 0; j < tasks.length; j++) {
            orderMap.put(tasks[j], j);
        }
        Arrays.sort(tasks, (a, b) -> a[0] - b[0]);
        int t = tasks[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            if (a[1] == b[1])
                return orderMap.get(tasks[a[2]]) - orderMap.get(tasks[b[2]]);
            return a[1] - b[1];
        });

        int[] out = new int[tasks.length];
        int j = 0, i = 0;
        while (i < tasks.length) {
            if (tasks[i][0] <= t) {
                pq.add(new int[] { tasks[i][0], tasks[i][1], i });
                i++;
                continue;
            }

            while (pq.size() > 0 && t < tasks[i][0]) {
                int[] curr = pq.poll();
                out[j++] = orderMap.get(tasks[curr[2]]);
                t += curr[1];
            }
            pq.add(new int[] { tasks[i][0], tasks[i][1], i });
            t = Math.max(t, tasks[i][0]);
            i++;
        }

        while (pq.size() > 0) {
            out[j++] = orderMap.get(tasks[pq.poll()[2]]);
        }
        return out;
    }
}