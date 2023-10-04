class Solution {
    int[] out = null;
    public int[] countVisitedNodes(List<Integer> edges) {
        out = new int[edges.size()];
        for(int i = 0; i < out.length; i++) {
            if(out[i] == 0) {
                dfs(i, edges, new HashMap());
            }
        }
        return out;
    }
    
    private int[] dfs(int index, List<Integer> edges, HashMap<Integer, Integer> path) {
        if(path.containsKey(index)) {
            return new int[]{ index, path.size()-path.get(index)}; //start of the cycle
        }
        
        if(out[index] > 0 ) return new int[]{-1, out[index]};
        
        path.put(index, path.size());
        
        int[] res = dfs(edges.get(index), edges, path);

        if(path.containsKey(res[0])) {
            out[index] = res[1];
        } else {
            res[1]++;
            res[0] = -1;
            out[index] = res[1];
        }
        
        path.remove(index);
        
        return res;
        
    }
}
