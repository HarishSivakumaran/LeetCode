class Solution {
    long[][] pascals = null;
    int mod = 1000000007;
    HashMap<Integer, long[]> cache = new HashMap();
    public int waysToBuildRooms(int[] prevRoom) {
        pascals = new long[prevRoom.length+1][prevRoom.length+1];
        generatePascals(prevRoom.length);
        HashMap<Integer, List<Integer>> adjList = new HashMap();
        for(int i = 0; i < prevRoom.length; i++) {
            adjList.computeIfAbsent(prevRoom[i], v -> new ArrayList()).add(i);
        }
        long[] out = getTopologicalWays(0, adjList);
        return (int)out[1];
    }

    private long[] getTopologicalWays(int node, HashMap<Integer, List<Integer>> adjList) {
        List<long[]> childrenData = new ArrayList();
        int totalChildren = 0;
        if(cache.containsKey(node)) return cache.get(node);
        
        if(adjList.containsKey(node))
            for(int next : adjList.get(node)) {
                long[] c = getTopologicalWays(next, adjList);
                childrenData.add(c);
                totalChildren += c[0];
            }
        long ways = 1;
        int copy = totalChildren;
        for(long[] c : childrenData) {
            ways *= (c[1] * pascals[totalChildren][(int)c[0]])%mod;
            ways %= mod;
            totalChildren -= c[0];
        }
        cache.put(node, new long[]{copy+1, ways});
        return new long[]{copy+1, ways};
    }


    private void generatePascals(int n) {
        pascals[0][0] = 1;
        for(int r = 1; r <= n; r++) {
            for(int c = 0; c <= r; c++) {
                pascals[r][c] = ((c-1 < 0) ? 0 : pascals[r-1][c-1]) + pascals[r-1][c];
                pascals[r][c] %= mod;
            }
        }
    }
}