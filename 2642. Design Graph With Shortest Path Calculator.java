class Graph {
    int n;
    HashMap<Integer, List<int[]>> adjList = new HashMap();
    public Graph(int n, int[][] edges) {
        this.n = n;
        for(int[] e : edges) {
            adjList.computeIfAbsent(e[0], v -> new ArrayList()).add(e);
        }
    }
    
    public void addEdge(int[] e) {
        adjList.computeIfAbsent(e[0], v -> new ArrayList()).add(e);       
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (a, b) -> a[1]-b[1]
        );

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;
        pq.add(new int[]{node1, dist[node1]});

        while(pq.size() > 0) {
            // visit a node
            int[] curr = pq.poll();
            if(visited[curr[0]]) continue;
            visited[curr[0]] = true;

            if(curr[0] == node2) return curr[1];

            //explore it's edges
            if(adjList.containsKey(curr[0])) {
                for(int[] next : adjList.get(curr[0])) {
                    if(dist[next[1]] > curr[1]+next[2]) {
                        dist[next[1]] = curr[1]+next[2];
                        pq.add(new int[] {next[1], dist[next[1]]});
                    }
                }
            }
        }
        return dist[node2] == Integer.MAX_VALUE ? -1 : dist[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */