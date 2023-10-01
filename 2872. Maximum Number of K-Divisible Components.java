class Solution {
    int comp = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        HashMap<Integer, List<Integer>> adjList = new HashMap();
        for(int[] e : edges) {
            adjList.computeIfAbsent(e[0], v -> new ArrayList()).add(e[1]);
            adjList.computeIfAbsent(e[1], v -> new ArrayList()).add(e[0]);
        }

        dfs(adjList, 0, -1, values, k);
        return comp;
    }
    private int dfs(HashMap<Integer, List<Integer>> adjList,
     int node, int prev, int[] val, int k) {
         int sum = val[node];
         if(adjList.containsKey(node))
         for(int next : adjList.get(node)) {
             if(next == prev) continue;
             sum += dfs(adjList, next, node, val, k);
         }

         if(sum%k == 0) comp++;
         return sum%k == 0 ? 0 : sum;
    }
}