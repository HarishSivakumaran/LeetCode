// 743. Network Delay Time

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        k--;
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<List<Pair<Integer,Integer>>> adj = new ArrayList();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }    

        for(int[] edge : times){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            adj.get(from-1).add(new Pair(to-1, weight));
        }   

        dist[k] = 0; //src
        dijkstraTravers(adj, dist, k, visited);

        int m = 0;

        for(int d : dist){
            m = Math.max(d, m);
        }

        if(m == Integer.MAX_VALUE) return -1;

        return m;

    }

    public void dijkstraTravers(List<List<Pair<Integer,Integer>>> adj, int[] dist, int node, boolean[] visited){

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b)-> a.getValue()-b.getValue());  

        pq.add(new Pair(node, dist[node]));

        while( pq.size() > 0 ){
            Pair<Integer, Integer> curr = pq.poll();
            if(visited[curr.getKey()]) continue;
            visited[curr.getKey()] = true;

            for(Pair<Integer,Integer> p : adj.get(curr.getKey())){
                int to = p.getKey();
                int w  = p.getValue();
                if(dist[to] > w + dist[curr.getKey()]) dist[to] = w + dist[curr.getKey()];
                pq.add(new Pair(to, dist[to]));
            }
        }        
    }
}