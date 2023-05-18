class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] incoming = new int[n];
        List<Integer> out = new ArrayList();

        for (List<Integer> edge : edges) {
            incoming[edge.get(1)]++;
        }

        for (int i = 0; i < incoming.length; i++) {
            if (incoming[i] == 0) {
                out.add(i);
            }
        }

        return out;
    }
}