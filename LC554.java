// 554. Brick Wall

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> edges = new HashMap();
        int count = 0;
        for (List<Integer> l : wall) {
            int c = 0;
            for (int i = 0; i < l.size() - 1; i++) {
                c += l.get(i);
                edges.put(c, edges.getOrDefault(c, 0) + 1);
                count = Math.max(count, edges.get(c));
            }
        }

        return wall.size() - count;
    }
}