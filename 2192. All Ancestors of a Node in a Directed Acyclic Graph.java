class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ancestors = new ArrayList(n);
        int[] indegree = new int[n];
        HashMap<Integer, List<Integer>> adjList = new HashMap();

        for(int[] e : edges) {
            indegree[e[1]]++;
            adjList.computeIfAbsent(e[0], v -> new ArrayList()).add(e[1]);
        }

        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < n; i++){
            ancestors.add(new ArrayList());
            if(indegree[i] == 0) q.add(i);
        }

        while(q.size() > 0){
            int curr = q.poll();
            if(adjList.containsKey(curr))
                for(int next : adjList.get(curr)) {
                    HashSet<Integer> set = new HashSet(ancestors.get(curr));
                    set.addAll(ancestors.get(next));
                    set.add(curr);
                    indegree[next]--;
                    if(indegree[next] == 0) q.add(next);
                    ancestors.set(next, new ArrayList(set));
                }
        }
        for(List<Integer> c : ancestors) {
            Collections.sort(c);
        }
        return ancestors;
    }
}