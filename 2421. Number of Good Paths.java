]class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        HashMap<Integer, List<Integer>> adjList = new HashMap();
        for(int[] e : edges) {
            adjList.computeIfAbsent(e[0], v -> new ArrayList()).add(e[1]);
            adjList.computeIfAbsent(e[1], v -> new ArrayList()).add(e[0]);
        }

        TreeMap<Integer, List<Integer>> groupsOfSameValue = new TreeMap();
        for(int i = 0; i < vals.length; i++) {
            groupsOfSameValue.computeIfAbsent(vals[i], v -> new ArrayList()).add(i);
        }

        UnionFind dsu = new UnionFind(vals.length);

        int ans = 0;

        for(Map.Entry<Integer, List<Integer>> entry : groupsOfSameValue.entrySet()) {
            for(int node : entry.getValue()) {
                if(adjList.containsKey(node))
                for(int neighbour : adjList.get(node)) {
                    if(vals[node] >= vals[neighbour]) {
                        dsu.union(node, neighbour);
                    }
                }
            }

            HashMap<Integer, Integer> goodPath = new HashMap();

            for(int node : entry.getValue()) {
                int par = dsu.getRoot(node);
                goodPath.put(par, goodPath.getOrDefault(par, 0)+1);
            }
            ans += entry.getValue().size();
            for(int val : goodPath.values()) ans += ((val*(val-1))/2);
        }
        
        return ans;
    }
}

class UnionFind{
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int getRoot(int i) {
        while(i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }

        return i;
    }

    public void union(int i, int j) {
        int p1 = getRoot(i);
        int p2 = getRoot(j);
        if(p1 == p2) return; // already connected

        if(rank[p1] > rank[p2] ) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
    }
}