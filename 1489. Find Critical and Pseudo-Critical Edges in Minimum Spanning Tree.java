class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        HashMap<Integer, List<int[]>> adjList = new HashMap();
        for(int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            // to, weight, index
            adjList.computeIfAbsent(e[0], v -> new ArrayList()).add(new int[]{e[1], e[2], i});
            adjList.computeIfAbsent(e[1], v -> new ArrayList()).add(new int[]{e[0], e[2], i});
        }
        int mstVal = getMST(n, adjList, -1, null);
       
        List<List<Integer>> out = new ArrayList();
        out.add(new ArrayList());
        out.add(new ArrayList());

        System.out.println(mstVal);

        for(int i = 0; i < edges.length; i++) {
            int newMst = getMST(n, adjList, i, null);
            if(newMst > mstVal){
                 out.get(0).add(i);
            } else {
                //now force
                int forced = getMST(n, adjList, -1, edges[i]);
                if(forced == mstVal)
                    out.get(1).add(i);
            } 
        }

        return out;

    }

    private int getMST(int n, HashMap<Integer, List<int[]>> adjList, int ignoreEdge, int[] forceEdge) {
        // pre-work
        HashMap<Integer, Integer> mstConnections = new HashMap();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            // {MST->toNode, edgeWeight, edgeIndex}
            (a, b) -> a[1]-b[1]
  
        );

        //Prim's MST algorithm
        int mst = 0;
        if(forceEdge != null) {
            mst += forceEdge[2];
            pq.add(new int[] {forceEdge[0], 0, 0});
            pq.add(new int[] {forceEdge[1], 0, 0});
        } else {
            pq.add(new int[]{0, 0, 0}); //node, weight with which it's connecting to the MST
        }
        while(mstConnections.size() < n && pq.size() > 0){
            int[] curr = pq.poll();
            if(mstConnections.containsKey(curr[0])) continue;
            mstConnections.put(curr[0], curr[1]);
            mst += curr[1];
            for(int[] next : adjList.get(curr[0])) {
                if(mstConnections.containsKey(next[0]) || ignoreEdge == next[2]) continue;
                pq.add(next);
            }
        }

        return mstConnections.size() < n ? Integer.MAX_VALUE : mst;
    }
}