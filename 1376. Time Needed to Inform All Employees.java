class Solution {
    int max = -1;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> adj = new HashMap();
        for(int i = 0; i < n; i++){
            adj.computeIfAbsent(manager[i], v -> new ArrayList()).add(i);
        }
        dfs(adj, informTime, headID, 0);

        return max;
    }

    public void dfs(HashMap<Integer, List<Integer>> adj, int[] infTime , int index, int t){
        if (adj.get(index) == null) {
            // leaf node
            max = Math.max(max, t);
            return;
        }

        int nextTime = t + infTime[index];

        for(int next : adj.get(index)) {
            dfs(adj, infTime, next, nextTime);
        }
    }
}