// 2359. Find Closest Node to Given Two Nodes

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if(node2 == node1) return node1;
        int[] d1 = new int[edges.length];
        bfs(node1,edges,d1); 
        
        int[] d2 = new int[edges.length];
        bfs(node2,edges,d2);

        int min = Integer.MAX_VALUE, minindex = -1;
        for(int i = 0; i < d1.length; i++){
            if(min >  Math.max(d1[i], d2[i])){
                minindex = i;
                min = Math.max(d1[i], d2[i]);
            }
        }


        return minindex;

    }

    public void bfs(int node1, int[]edges, int[] dist){
        Queue<Integer> q = new LinkedList();
        HashSet<Integer> visited = new HashSet();
        q.add(node1);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;
        while(q.size()>0){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int node = q.poll();
                if(visited.contains(node)) continue;
                   visited.add(node);
                int next = edges[node];
                if(next != -1){
                    if(dist[next] > dist[node]+1) dist[next] = dist[node]+1;
                    q.add(next);
                }
            }
        }
    }
}