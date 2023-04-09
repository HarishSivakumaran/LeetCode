// 1857. Largest Color Value in a Directed Graph

class Solution {

    public int largestPathValue(String colors, int[][] edges) {
        HashMap<Integer, List<Integer>> adjList = new HashMap();

        int n = colors.length();

        int[] incoming = new int[n];

        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], v -> new ArrayList()).add(edge[1]);
            incoming[edge[1]]++;
        }

        HashMap<Integer, int[]> colorCount = new HashMap();

        Queue<Integer> q = new LinkedList();

        for (int i = 0; i < n; i++) {
            if (incoming[i] == 0)
                q.add(i);
        }

        int ans = 0, visitedNodes = 0;

        while (q.size() > 0) {

            int curr = q.poll();

            int[] currentColorList = colorCount.computeIfAbsent(curr, v -> new int[26]);
            currentColorList[colors.charAt(curr) - 'a']++;
            ans = Math.max(ans, currentColorList[colors.charAt(curr) - 'a']);
            visitedNodes++;

            if (!adjList.containsKey(curr))
                continue;

            for (int neighbour : adjList.get(curr)) {
                int[] neighColorList = colorCount.computeIfAbsent(neighbour, v -> new int[26]);
                for (int i = 0; i < 26; i++) {
                    neighColorList[i] = Math.max(neighColorList[i], currentColorList[i]);
                }
                incoming[neighbour]--;
                if (incoming[neighbour] == 0) {
                    q.add(neighbour);
                }

            }

        }

        return visitedNodes == n ? ans : -1;

    }

    // public int[] dfs(int i, HashMap<Integer, List<Integer>> adjList, String
    // colors, HashSet<Integer> path){

    // // if(cycle || path.contains(i)){
    // // cycle = true;
    // // return null;
    // // }

    // if(map.containsKey(i)) return map.get(i);

    // int[] col = new int[26], temp = null;

    // if(adjList.containsKey(i)){
    // path.add(i);
    // for(int j : adjList.get(i)){
    // temp = dfs(j, adjList, colors, path);
    // if(temp == null) break;
    // for(int z = 0; z < 26; z++){
    // col[z] = Math.max(col[z], temp[z]);
    // }
    // }
    // path.remove(i);
    // }

    // col[colors.charAt(i)-'a']++;

    // map.put(i, col);

    // return col;
    // }
}