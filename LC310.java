//310. Minimum Height Trees

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> out = new ArrayList<Integer>();
        if(n < 3){
            for(int i = 0; i < n; i++){
                out.add(i);
            }
            return out;
        }
        HashMap<Integer,List<Integer>> adj = new HashMap();

        for(int[] e : edges){
            adj.computeIfAbsent(e[0], value -> new ArrayList()).add(e[1]);
            adj.computeIfAbsent(e[1], value -> new ArrayList()).add(e[0]);
        }

        Queue<Integer> q = new LinkedList();

        for(Map.Entry<Integer, List<Integer>> entry : adj.entrySet()){
            if(entry.getValue().size() == 1) q.add(entry.getKey()); // add all leaf nodes
        }

        // multisource BFS until the HashSet contains only n - 2;

        while(n > 2){
            int len = q.size();
            n -= len;

            for(int i = 0; i < len; i++){
                int curr = q.poll();
                int l = adj.get(curr).get(0);
                adj.get(l).remove(Integer.valueOf(curr));
                for(int e : adj.get(curr)){
                    if(adj.get(e).size() == 1) q.add(e);
                }
            }
        }

        for(int j : q){
            out.add(j);
        }

        return out;
        
    }
}
