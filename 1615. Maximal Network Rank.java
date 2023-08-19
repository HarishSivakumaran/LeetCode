class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> adjList = new HashMap();
        int[] indegree = new int[n];

        for(int[] r : roads) {
            adjList.computeIfAbsent(r[0], v -> new HashSet()).add(r[1]);
            adjList.computeIfAbsent(r[1], v -> new HashSet()).add(r[0]);
            indegree[r[0]]++;
            indegree[r[1]]++;
        }

        int maxInfrast = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                maxInfrast = Math.max(maxInfrast, 
                    indegree[i]+indegree[j]-(
                        (adjList.containsKey(i) && adjList.get(i).contains(j) ? 1 : 0)
                        )
                );
            }
        }

        return maxInfrast;
    }
}