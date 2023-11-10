class Solution {
    public int[] restoreArray(int[][] pairs) {
        int[] out = new int[pairs.length+1];
        HashMap<Integer, List<int[]>> map = new HashMap();
        for(int[] pair : pairs) {
            map.computeIfAbsent(pair[0], v -> new ArrayList()).add(pair);
            map.computeIfAbsent(pair[1], v -> new ArrayList()).add(pair);
        }

        int start = 0;
        for(int key : map.keySet()) {
            if(map.get(key).size() == 1) {
                start = key;
                break;
            }
        }

        dfs(map, start, 0, out, new HashSet());
        return out;
    }

    private boolean dfs(HashMap<Integer, List<int[]>> map, 
    int curr, int index, int[] out, HashSet<int[]> visited) {
        if(index >= out.length) return true;

        out[index] = curr;
        for(int[] pair : map.get(curr)) {
            if(visited.contains(pair)) continue;
            visited.add(pair);
            boolean found = dfs(map, pair[0] == curr ? pair[1] : pair[0],
                                index+1, out, visited);
            if(found) return true;
            visited.remove(pair);
        }

        return false;
    }
}