// 1857. Largest Color Value in a Directed Graph

class Solution {

    int[] finalVal = new int[26];
    HashMap<Integer, int[]> map = new HashMap();
    boolean cycle = false;

    public int largestPathValue(String colors, int[][] edges) {
        HashMap<Integer, List<Integer>> adjList = new HashMap();

        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], v -> new ArrayList()).add(edge[1]);
        }

        int[] temp = null;
        for (int i = 0; i < colors.length(); i++) {
            temp = dfs(i, adjList, colors, new HashSet());
            if (temp == null)
                break;
            for (int z = 0; z < 26; z++) {
                finalVal[z] = Math.max(finalVal[z], temp[z]);
            }
        }

        if (cycle)
            return -1;

        int max = finalVal[0];

        for (int i : finalVal) {
            if (i > max) {
                max = i;
            }
        }

        return max;

    }

    public int[] dfs(int i, HashMap<Integer, List<Integer>> adjList, String colors, HashSet<Integer> path) {

        if (cycle || path.contains(i)) {
            cycle = true;
            return null;
        }

        if (map.containsKey(i))
            return map.get(i);

        int[] col = new int[26], temp = null;

        if (adjList.containsKey(i)) {
            path.add(i);
            for (int j : adjList.get(i)) {
                temp = dfs(j, adjList, colors, path);
                if (temp == null)
                    break;
                for (int z = 0; z < 26; z++) {
                    col[z] = Math.max(col[z], temp[z]);
                }
            }
            path.remove(i);
        }

        col[colors.charAt(i) - 'a']++;

        map.put(i, col);

        return col;
    }
}