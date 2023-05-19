class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] marker = new int[graph.length];
        boolean finalval = true;
        for (int i = 0; i < graph.length; i++)
            finalval = finalval && isBipariteGr(graph, i, marker[i] == 0 ? 1 : marker[i], marker);

        return finalval;
    }

    public boolean isBipariteGr(int[][] graph, int index, int val, int[] marker) {
        if (marker[index] != 0 && marker[index] != val)
            return false;
        if (marker[index] != 0)
            return true;

        marker[index] = val;

        int nextVal = val == 1 ? 2 : 1;

        boolean check = true;

        for (int edge : graph[index]) {
            check = isBipariteGr(graph, edge, nextVal, marker) && check;
        }

        return check;

    }
}