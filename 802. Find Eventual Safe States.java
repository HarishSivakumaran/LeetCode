class Solution {
    Boolean[] cyclicNodes = null;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer, List<Integer>> adjList = new HashMap();
        cyclicNodes = new Boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
                List<Integer> l = new ArrayList<Integer>();
                adjList.put(i, l);
                for(int n : graph[i]) l.add(n);
        }

        for(int i = 0; i < graph.length; i++) {
            dfs(i, new HashSet(), adjList);
        }
        List<Integer> out = new ArrayList();
        for(int i = 0; i < cyclicNodes.length; i++) {
            if(!cyclicNodes[i]) out.add(i);
        }

        return out;
    }

    private boolean dfs(int node, HashSet<Integer> path, HashMap<Integer, List<Integer>> adjList) {
        if(path.contains(node)){
            // found a cycle removing cyclic nodes
            return true;
        }

        if(cyclicNodes[node] != null) return cyclicNodes[node];
        boolean hasCycle = false;
        if(adjList.get(node) != null)
        for(int next : adjList.get(node)) {
            path.add(node);
            hasCycle = dfs(next, path, adjList) | hasCycle; 
            path.remove(node);
        }

        return cyclicNodes[node] = hasCycle;
    }
}