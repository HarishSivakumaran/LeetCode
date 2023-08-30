class Solution {
    int mod = 1000000007;
    public int countPaths(int n, int[][] roads) {
        int[] dist = new int[n];
        long[] ways = new long[n];
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<int[]>> adjList = new HashMap();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        for(int[] r : roads){
            adjList.computeIfAbsent(r[0], v -> new ArrayList()).add(new int[]{r[1], r[2]});
            adjList.computeIfAbsent(r[1], v -> new ArrayList()).add(new int[]{r[0], r[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1]-b[1]);
        pq.add(new int[]{0, 0}); //node, dist
        int ans = 0;

        while(pq.size() > 0) {
            int[] curr = pq.poll();
            if(visited[curr[0]]) continue;
            visited[curr[0]] = true;

            // check for final node
            if(curr[0] == n-1) {
                return (int)ways[n-1];
            }

            for(int[] next : adjList.get(curr[0])) {
                if(visited[next[0]]) continue;
                if(curr[1]+next[1] <= dist[next[0]]) {
                    boolean isSameVal = curr[1]+next[1] == dist[next[0]];
                    dist[next[0]] = curr[1]+next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                    if(isSameVal) {
                        ways[next[0]] += ways[curr[0]];
                    } else {
                        ways[next[0]] = ways[curr[0]];
                    }
                    ways[next[0]] %= mod;
                }
            }
        }

        return ans;
    }
}