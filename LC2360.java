// 2360. Longest Cycle in a Graph

class Solution {
    int res = -1;
    HashSet<Integer> visited = new HashSet();

    public int longestCycle(int[] edges) {
        for (int i = 0; i < edges.length; i++) {
            if (visited.contains(i))
                continue;
            dfs(edges, i, new HashMap(), new ArrayList());
        }

        return res;
    }

    public void dfs(int[] edges, int i, HashMap<Integer, Integer> map, List<Integer> path) {
        if (i >= edges.length || visited.contains(i))
            return;

        if (map.containsKey(i)) {
            res = Math.max(res, path.size() - map.get(i));
            return;
        }

        map.put(i, path.size());
        path.add(i);
        if (edges[i] != -1)
            dfs(edges, edges[i], map, path);

        visited.add(i);

    }
}